-- Creamos la BD
create database softlearning_springboot;

-- Utilizamos la BD
use softlearning_springboot;

-- Creamos la tabla de Books
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `nameproduct` varchar(100) NOT NULL,
  `price` int NOT NULL,
  `description` text,
  `category` varchar(100) DEFAULT NULL,
  `languages` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `isbn` varchar(20) NOT NULL,
  `pages` int DEFAULT NULL,
  `date_publicated` varchar(255) DEFAULT NULL,
  `date_disponibility` varchar(255) DEFAULT NULL,
  `high` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `fragile` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insertamos datos en Books
LOCK TABLES `books` WRITE;
INSERT INTO `books` VALUES ('PHP y Java',2000,'Libro de PHP','Educacion','English','Austria Jimenez','1234567890133',1000,'11-02-2025','11-02-2025 14:30:00',10.5,15,20,1.5,1);
UNLOCK TABLES;

-- Mostramos los datos que hay en Books
select * from books;

-- Creamos la tabla de Clients
DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `cognoms` varchar(100) DEFAULT NULL,
  `phone_number` int DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `dni` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `workers` int DEFAULT NULL,
  `social_reason` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insertamos datos en Clients
LOCK TABLES `clients` WRITE;
INSERT INTO `clients` VALUES (1,'Carlos','Calle Gran Vía, 20','Gómez Sánchez',612345678,28001,'carlos.gomez@email.com','1985-08-15','12345678Z',40,25,'Futbol Club Madrid'),(2,'AnaMari','Calle Mayor, 15','Pérez López',678901234,28012,'ana.perez@email.com','1990-03-10','87654321X',34,50,'Tech Solutions S.L.');
UNLOCK TABLES;

-- Mostramos los datos que hay en Clients
select * from clients;

-- Creamos la tabla de Courses
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` int NOT NULL,
  `nameproduct` varchar(255) DEFAULT NULL,
  `description` text,
  `category` varchar(255) DEFAULT NULL,
  `languages` varchar(255) DEFAULT NULL,
  `courses` varchar(255) DEFAULT NULL,
  `tutor` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `duration` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insertamos valores en Courses
LOCK TABLES `courses` WRITE;
INSERT INTO `courses` VALUES (1,'Fútbolin','Curso avanzado de técnicas de fútbol para entrenadores.','Deportes','Español','Entrenamiento','José Martínez',150,30),(2,'Basketball Pro','Curso','Deportes','Inglés','Preparación','Luka',200,45),(101,'Fútbol Avanzado','Curso avanzado de técnicas de fútbol para entrenadores.','Deportes','Español','Entrenamiento','José Martínez',150,30);
UNLOCK TABLES;

-- Mostramos los datos que hay en Courses
select * from courses;

-- Creamos la tabla de Employees
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int NOT NULL,
  `phone_number` int DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` text,
  `cognoms` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `days` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insertamos valores en Employees
LOCK TABLES `employees` WRITE;
INSERT INTO `employees` VALUES (1,612345678,28001,2500,'Luis','Calle Fútbol, 15','Rodríguez García','luis.rodriguez@fcbarcelona.com','12-05-1990','Entrenador','luis90','seguro123','20-11-2021'),(2,687654321,28005,3000,'Clara','Calle Baloncesto, 10','López','clara@basketworld.com','20-07-1988','Preparadora Física','clara88','clave456','15-02-2025');
UNLOCK TABLES;

-- Mostramos los datos que hay en Employees
select * from employees;

-- Creamos la tabla de providers
DROP TABLE IF EXISTS `providers`;
CREATE TABLE `providers` (
  `id` int NOT NULL,
  `phone_number` int DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `workers` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` text,
  `cognoms` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `schedule` varchar(255) DEFAULT NULL,
  `work` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `social_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insertamos valores en providers
LOCK TABLES `providers` WRITE;
INSERT INTO `providers` VALUES (1,618123456,76895,50,'Proveedores Fútbol S.A.','Avenida del Deporte, 42','Martínez Pérez','contacto@proveedoresfutbol.com','28-03-2005','Morning','Distribución de material deportivo','admin@proveedoresfutbol.com','contraseñaSegura2025','Suministro de equipamiento deportivo para clubes'),(2,619876543,12345,100,'Deportes Elite S.L.','Calle del Deporte, 99','López Sánchez','info@deporteselite.com','2010-05-15','Night','ropa deportiva','admin@deporteselite.com','passSeguro2025','Proveedor de ropa');
UNLOCK TABLES;

-- Mostramos los datos que hay en Providers
select * from providers;