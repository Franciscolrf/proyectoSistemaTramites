-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS sistematramites;
USE sistematramites;

-- Crear la tabla Persona
CREATE TABLE IF NOT EXISTS Persona (
    idPersona INT PRIMARY KEY AUTO_INCREMENT,
    RFC VARCHAR(13) UNIQUE,
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
    idPersona INT,
    fechaExpedicion DATE,
    fechaVencimiento DATE,
    costo DECIMAL(10, 2),
    estado ENUM('expirada', 'no expirada'),
    vigencia INT,
    FOREIGN KEY (idPersona) REFERENCES Persona(idPersona)
);

-- Crear trigger para actualizar el estado de la licencia
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
    idVehiculo INT PRIMARY KEY AUTO_INCREMENT,
    numeroSerie VARCHAR(20) UNIQUE,
    estado VARCHAR(50),
    color VARCHAR(50),
    modelo VARCHAR(50),
    marca VARCHAR(50),
    linea VARCHAR(50),
    idPersona INT,
    tipoVehiculo VARCHAR(50),
    FOREIGN KEY (idPersona) REFERENCES Persona(idPersona)
);

-- Crear la tabla Placa
CREATE TABLE IF NOT EXISTS Placa (
    idPlaca INT PRIMARY KEY AUTO_INCREMENT,
    idVehiculo INT,
    codigo VARCHAR(20) UNIQUE,
    fechaRecepcion DATE,
    estado ENUM('activa', 'inactiva'),
    fechaExpedicion DATE,
    costo DECIMAL(10, 2),
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo)
);

-- Trigger para asegurar que no se pueda tener más de una placa activa por vehículo
DELIMITER //
CREATE TRIGGER asegurar_placa_activa BEFORE INSERT ON Placa
FOR EACH ROW
BEGIN
    DECLARE count_active INT;
    SELECT COUNT(*) INTO count_active FROM Placa WHERE codigo = NEW.codigo AND estado = 'activa';
    IF count_active > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede tener más de una placa activa por vehículo';
    END IF;
END;
//
DELIMITER ;

-- Trigger para actualizar el estado de un vehiculo si tiene placas inactivas
DELIMITER //
CREATE TRIGGER actualizar_estado_vehiculo AFTER INSERT ON Placa
FOR EACH ROW
BEGIN
    DECLARE vehiculo_estado VARCHAR(50);
    
    SELECT estado INTO vehiculo_estado FROM Vehiculo WHERE idVehiculo = NEW.idVehiculo;

    IF EXISTS (SELECT * FROM Placa WHERE idVehiculo = NEW.idVehiculo AND estado = 'Inactiva') THEN
       
        IF vehiculo_estado != 'Usado' THEN
            UPDATE Vehiculo SET estado = 'Usado' WHERE idVehiculo = NEW.idVehiculo;
        END IF;
    END IF;
END;
//
DELIMITER ;
