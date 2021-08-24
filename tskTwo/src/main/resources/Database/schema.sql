CREATE TABLE IF NOT EXISTS Genre
(
    id    BIGSERIAL PRIMARY KEY,
    genre_name  VARCHAR(100),
    description VARCHAR(500),
    date_of_creation DATE  NOT NULL,
    date_of_modification DATE  NOT NULL
);

CREATE TABLE IF NOT EXISTS Author
(
    id    BIGSERIAL PRIMARY KEY,
    first_name  VARCHAR(200) NOT NULL,
    last_name  VARCHAR(200) NOT NULL,
    middle_name  VARCHAR(200) NOT NULL,
    date_of_birth DATE NOT NULL,
    date_of_creation DATE  NOT NULL,
    date_of_modification DATE  NOT NULL
);

CREATE TABLE IF NOT EXISTS Book
(
    id    BIGSERIAL PRIMARY KEY,
    title  VARCHAR(200) NOT NULL,
    ISBN VARCHAR(13) NOT NULL,
    date_of_creation DATE  NOT NULL,
    date_of_modification DATE  NOT NULL,
    genre_id BIGSERIAL NOT NULL REFERENCES Genre(id)
);

CREATE TABLE IF NOT EXISTS Authors_Books
(
    author_id BIGSERIAL CONSTRAINT authors_books_author_id_fk REFERENCES Author(id),
    book_id BIGSERIAL CONSTRAINT authors_books_book_id_fk REFERENCES Book(id)
);
