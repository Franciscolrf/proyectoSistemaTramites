-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS sistematramites;
USE sistematramites;

-- Crear la tabla Persona
CREATE TABLE IF NOT EXISTS Persona (
    idPersona int PRIMARY KEY,
    RFC VARCHAR(13) UNIQUE ,
    fechaNacimiento DATE,
    esDiscapacitado BOOLEAN,
    telefono VARCHAR(20),
    nombres VARCHAR(50),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50)
);


-- Crear la tabla Licencia
CREATE TABLE IF NOT EXISTS Licencia (
    idLicencia INT AUTO_INCREMENT PRIMARY KEY,
    idPersona int,
    fechaExpedicion DATE,
    fechaVencimiento DATE,
    costo DECIMAL(10, 2),
    estado ENUM('expirada', 'no expirada'),
    vigencia int,
    FOREIGN KEY (idPersona) REFERENCES Persona(idPersona)
);

/*Crear trigger para actualizar el estado de la licencia */
DELIMITER //
CREATE TRIGGER actualizar_estado_licencia BEFORE INSERT ON Licencia
FOR EACH ROW
BEGIN
    IF NEW.fechaVencimiento < CURDATE() THEN
        SET NEW.estado = 'expirada';
    ELSE
        SET NEW.estado = 'no expirada';
    END IF;
END;
//
DELIMITER ;

-- Crear la tabla Vehiculo
CREATE TABLE IF NOT EXISTS Vehiculo (
    idVehiculo int PRIMARY KEY,
    numeroSerie VARCHAR(20) UNIQUE,
    estado VARCHAR(50),
    color VARCHAR(50),
    modelo VARCHAR(50),
    marca VARCHAR(50),
    linea VARCHAR(50),
    idPersona int,
    FOREIGN KEY (idPersona) REFERENCES Persona(idPersona)
);

-- Crear la tabla Automovil que hereda de Vehiculo
CREATE TABLE IF NOT EXISTS Automovil (
    idAutomovil INT AUTO_INCREMENT PRIMARY KEY,
    tipoAutomovil VARCHAR(50),
	idVehiculo int,
    FOREIGN KEY ( idVehiculo) REFERENCES Vehiculo( idVehiculo)
);

-- Crear la tabla Placa
CREATE TABLE IF NOT EXISTS Placa (
    idPlaca int PRIMARY KEY,
    idVehiculo int,
    codigo VARCHAR(20) UNIQUE,
    fechaRecepcion DATE,
    estado ENUM('activa', 'inactiva'),
    fechaExpedicion DATE,
    costo DECIMAL(10, 2),
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo)
);

/*Crear trigger para asegurar que no se pueda tener más de una placa activa por vehículo */
DELIMITER //
CREATE TRIGGER asegurar_placa_activa BEFORE INSERT ON Placa
FOR EACH ROW
BEGIN
    DECLARE count_active INT;
    SELECT COUNT(*) INTO count_active FROM Placa WHERE numeroSerie = NEW.numeroSerie AND estado = 'activa';
    IF count_active > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede tener más de una placa activa por vehículo';
    END IF;
END;
//
DELIMITER ;

/*Crear trigger para asegurar que no se pueda solicitar una placa sin una licencia activa */
DELIMITER //
CREATE TRIGGER asegurar_licencia_activa BEFORE INSERT ON Placa
FOR EACH ROW
BEGIN
    DECLARE count_active_licenses INT;
    SELECT COUNT(*) INTO count_active_licenses FROM Licencia WHERE RFC_persona = (SELECT RFC_propietario FROM Vehiculo WHERE numeroSerie = NEW.numeroSerie) AND estado = 'no expirada';
    IF count_active_licenses = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede solicitar una placa sin una licencia activa';
    END IF;
END;
//
DELIMITER ;


/*Trigger para actualizar automaticamente el estado de la placa*/
DELIMITER //
CREATE TRIGGER actualizar_estado_placa BEFORE UPDATE ON Placa
FOR EACH ROW
BEGIN
    IF OLD.estado != NEW.estado THEN
        IF NEW.estado = 'activa' THEN
            UPDATE Placa SET estado = 'inactiva' WHERE numeroSerie = NEW.numeroSerie AND estado = 'activa';
        END IF;
    END IF;
END;
//
DELIMITER ;

