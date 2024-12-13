-- Créer la base de données superviseurs
CREATE DATABASE superviseurs;
USE superviseurs;

-- Créer la table Membre
CREATE TABLE membre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20)
);

-- Créer la table Incident
CREATE TABLE incident (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_membre INT,
    reference VARCHAR(50),
    status VARCHAR(50),
    time DATETIME,
    FOREIGN KEY (id_membre) REFERENCES Membre(id)
);

INSERT INTO membre (nom, prenom, email, phone) VALUES
('Dupont', 'Jean', 'jean.dupont@example.com', '0123456789'),
('Durand', 'Marie', 'marie.durand@example.com', '0987654321'),
('Martin', 'Paul', 'paul.martin@example.com', '0112233445'),
('Bernard', 'Claire', 'claire.bernard@example.com', '0223344556'),
('Petit', 'Julien', 'julien.petit@example.com', '0334455667'),
('Moreau', 'Sophie', 'sophie.moreau@example.com', '0445566778'),
('Lemoine', 'Laura', 'laura.lemoine@example.com', '0556677889');

INSERT INTO incident (id_membre, reference, status, time) VALUES
(1, 'REF001', 'Open', '2024-12-01 10:00:00'),
(2, 'REF002', 'Closed', '2024-12-02 14:30:00'),
(3, 'REF003', 'Pending', '2024-12-03 09:15:00'),
(1, 'REF004', 'Open', '2024-12-04 11:45:00'),
(4, 'REF005', 'Resolved', '2024-12-05 16:20:00'),
(5, 'REF006', 'Closed', '2024-12-06 08:50:00'),
(2, 'REF007', 'Open', '2024-12-07 13:10:00'),
(6, 'REF008', 'Pending', '2024-12-08 17:30:00'),
(3, 'REF009', 'Resolved', '2024-12-09 10:25:00'),
(7, 'REF010', 'Open', '2024-12-10 12:00:00');


