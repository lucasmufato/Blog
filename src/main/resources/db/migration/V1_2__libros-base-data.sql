INSERT INTO AUTORES (id, apellido, nombre, created_on, modified_on)
VALUES (1, 'Cortázar', 'Julio', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (2, 'Borges', 'Jorge Luis', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (3, 'García Márquez', 'Gabriel', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (4, 'Vargas Llosa', 'Mario', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (5, 'Amado', 'Jorge', '2018-08-08 21:54:00', '2018-08-08 21:54:00');

INSERT INTO LIBROS (id, titulo, isbn, id_autor, created_on, modified_on)
VALUES (1, 'Rayuela', '23471', 1, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (2, 'El Aleph', '21356', 2, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (3, 'Historias de cronopios y de famas', '16434', 1, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (4, '100 años de soledad', '84755', 3, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (5, 'La guerra del fin del mundo', '49233', 4, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (6, 'Doña Flor y sus dos maridos', '45036', 4, '2018-08-08 21:54:00', '2018-11-08 21:54:00');
