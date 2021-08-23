CREATE TABLE IF NOT EXISTS Genre
(
    id    BIGSERIAL PRIMARY KEY,
    genreName  VARCHAR(100),
    description VARCHAR(500),
    dateOfCreation DATE  NOT NULL,
    dateOfModification DATE  NOT NULL
);

CREATE TABLE IF NOT EXISTS Author
(
    id    BIGSERIAL PRIMARY KEY,
    firstName  VARCHAR(200) NOT NULL,
    lastName  VARCHAR(200) NOT NULL,
    middleName  VARCHAR(200) NOT NULL--,
    --dateOfBirth DATE NOT NULL,
    --dateOfCreation DATE  NOT NULL,
    --dateOfModification DATE  NOT NULL
);

CREATE TABLE IF NOT EXISTS Book
(
    id    BIGSERIAL PRIMARY KEY,
    title  VARCHAR(200) NOT NULL,
    ISBN VARCHAR(13) NOT NULL,
    dateOfCreation DATE  NOT NULL,
    dateOfModification DATE  NOT NULL,
    genreID BIGSERIAL NOT NULL REFERENCES Genre(id)
);

CREATE TABLE IF NOT EXISTS Authors_Books
(
    author_id BIGSERIAL CONSTRAINT authors_books_author_id_fk REFERENCES Author(id),
    book_id BIGSERIAL CONSTRAINT authors_books_book_id_fk REFERENCES Book(id)
);
