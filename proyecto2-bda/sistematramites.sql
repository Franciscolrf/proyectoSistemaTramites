-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS sistematramites;
USE sistematramites;

-- Crear la tabla Persona
CREATE TABLE IF NOT EXISTS Persona (
    RFC VARCHAR(13) PRIMARY KEY,
    fechaNacimiento DATE,
    esDiscapacitado BOOLEAN,
    telefono VARCHAR(15),
    nombres VARCHAR(50),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50)
);

/*Trigger para evitar que se pueda modificar el RFC en la tabla Persona*/
DELIMITER //
CREATE TRIGGER restriccion_modificacion_RFC BEFORE UPDATE ON Persona
FOR EACH ROW
BEGIN
    IF OLD.RFC != NEW.RFC THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede modificar el RFC de una persona';
    END IF;
END;
//
DELIMITER ;

-- Crear la tabla Licencia
CREATE TABLE IF NOT EXISTS Licencia (
    idLicencia INT AUTO_INCREMENT PRIMARY KEY,
    RFC_persona VARCHAR(13),
    fechaExpedicion DATE,
    fechaVencimiento DATE,
    costo DECIMAL(10, 2),
    estado ENUM('expirada', 'no expirada'),
    FOREIGN KEY (RFC_persona) REFERENCES Persona(RFC)
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
    numeroSerie VARCHAR(20) PRIMARY KEY,
    estado VARCHAR(50),
    color VARCHAR(50),
    modelo VARCHAR(50),
    marca VARCHAR(50),
    linea VARCHAR(50),
    RFC_propietario VARCHAR(13),
    FOREIGN KEY (RFC_propietario) REFERENCES Persona(RFC)
);

-- Crear la tabla Automovil que hereda de Vehiculo
CREATE TABLE IF NOT EXISTS Automovil (
    idAutomovil INT AUTO_INCREMENT PRIMARY KEY,
    tipoAutomovil VARCHAR(50),
    numeroSerieVehiculo VARCHAR(20),
    FOREIGN KEY (numeroSerieVehiculo) REFERENCES Vehiculo(numeroSerie)
);

-- Crear la tabla Placa
CREATE TABLE IF NOT EXISTS Placa (
    numeroSerie VARCHAR(20),
    fechaRecepcion DATE,
    estado ENUM('activa', 'inactiva'),
    fechaExpedicion DATE,
    costo DECIMAL(10, 2),
    PRIMARY KEY (numeroSerie),
    FOREIGN KEY (numeroSerie) REFERENCES Vehiculo(numeroSerie)
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

/*Trigger para evitar que se pueda eliminar un vehiculo con placas activas*/
DELIMITER //
CREATE TRIGGER evitar_eliminacion_vehiculo_placas_activas BEFORE DELETE ON Vehiculo
FOR EACH ROW
BEGIN
    DECLARE count_active_plates INT;
    SELECT COUNT(*) INTO count_active_plates FROM Placa WHERE numeroSerie = OLD.numeroSerie AND estado = 'activa';
    IF count_active_plates > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede eliminar un vehículo con placas activas';
    END IF;
END;
//
DELIMITER ;

/*Trigger para evitar que se pueda eliminar una persona con licencias activas*/
DELIMITER //
CREATE TRIGGER evitar_eliminacion_persona_licencias_activas BEFORE DELETE ON Persona
FOR EACH ROW
BEGIN
    DECLARE count_active_licenses INT;
    SELECT COUNT(*) INTO count_active_licenses FROM Licencia WHERE RFC_persona = OLD.RFC AND estado = 'no expirada';
    IF count_active_licenses > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede eliminar una persona con licencias activas';
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

/*Trigger para evitar que se pueda eliminar una licencia con unas placas activas.*/
DELIMITER //
CREATE TRIGGER evitar_eliminacion_licencia_placas_activas BEFORE DELETE ON Licencia
FOR EACH ROW
BEGIN
    DECLARE count_active_plates INT;
    SELECT COUNT(*) INTO count_active_plates FROM Placa P JOIN Vehiculo V ON P.numeroSerie = V.numeroSerie WHERE RFC_persona = OLD.RFC_persona AND estado = 'activa';
    IF count_active_plates > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede eliminar una licencia con vehículos que tengan placas activas';
    END IF;
END;
//
DELIMITER ;

/*Trigger para evitar que se pueda eliminar un vehiculo con una licencia activa*/
DELIMITER //
CREATE TRIGGER evitar_eliminacion_vehiculo_licencias_activas BEFORE DELETE ON Vehiculo
FOR EACH ROW
BEGIN
    DECLARE count_active_licenses INT;
    SELECT COUNT(*) INTO count_active_licenses FROM Licencia WHERE RFC_persona = OLD.RFC_propietario AND estado = 'no expirada';
    IF count_active_licenses > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede eliminar un vehículo con licencias activas';
    END IF;
END;
//
DELIMITER ;

/*Trigger para evitar que se pueda eliminar una persona con un vehiculo activo */
DELIMITER //
CREATE TRIGGER evitar_eliminacion_persona_vehiculos_activos BEFORE DELETE ON Persona
FOR EACH ROW
BEGIN
    DECLARE count_active_vehicles INT;
    SELECT COUNT(*) INTO count_active_vehicles FROM Vehiculo WHERE RFC_propietario = OLD.RFC;
    IF count_active_vehicles > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede eliminar una persona con vehículos activos';
    END IF;
END;
//
DELIMITER ;

