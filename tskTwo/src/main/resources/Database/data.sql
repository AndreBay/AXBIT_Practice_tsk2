INSERT INTO Genre VALUES
(1, 'Romance', 'Nothing interesting', '1690-03-03', '1690-03-03'),
(2, 'Textbook', 'For sudents', '1790-03-04', '1790-03-06'),
(3, 'Taskbook', 'Information about science technologies', '2010-03-30', '2010-04-30');

INSERT INTO Author VALUES
(1, 'Chris', 'Lord', 'Alge', '1964-09-24', '2021-06-04', '2021-07-05'),
(2, 'William', ' ','Shakespeare', '1564-04-26', '2021-07-04', '2021-02-05'),
(3, 'Jules', 'Gabriel', 'Verne', '1828-02-08', '2021-08-04', '2021-05-30'),
(4, 'Andrew', ' ','Scheps', '1972-11-16', '2021-03-04', '2021-03-05');

INSERT INTO Book VALUES
(1, 'Romeo and Juliette', '12-13-4312423', '2021-03-04', '2021-03-05', 2),
(2, 'Sound for Dummies', '33-12-5243112', '2021-03-04', '2021-03-05', 1),
(3, 'Vingt mille lieues sous les mers', '32-78-0237064', '2021-03-04', '2021-03-05', 3),
(4, 'Voyage au centre de la Terre', '67-37-3682467', '2021-03-04', '2021-03-05', 3),
(5, 'LÎle mystérieuse', '64-87-0202567', '2021-03-04', '2021-03-05', 3);

INSERT INTO Authors_Books VALUES
(2,1),
(1,2),
(4,2),
(3,3),
(3,4),
(3,5);
