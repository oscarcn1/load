CREATE TABLE articulos (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  descripcion VARCHAR(255),
  precio NUMERIC(10, 2) NOT NULL
);