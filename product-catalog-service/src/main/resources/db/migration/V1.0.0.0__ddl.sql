-- Table: product_catalog.ingredients

DROP TABLE IF EXISTS product_catalog.ingredients;

CREATE TABLE IF NOT EXISTS product_catalog.ingredients
(
    calories_per_unit real NOT NULL,
    version integer,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    id uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    unit character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT ingredients_pkey PRIMARY KEY (id),
    CONSTRAINT ingredients_unit_check CHECK (unit::text = ANY (ARRAY['G'::character varying, 'L'::character varying]::text[]))
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS product_catalog.ingredients
    OWNER to ms_product_catalog_user;


-- Table: product_catalog.products

DROP TABLE IF EXISTS product_catalog.products;

CREATE TABLE IF NOT EXISTS product_catalog.products
(
    amount double precision NOT NULL,
    version integer,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    id uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    unit character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id),
    CONSTRAINT products_type_check CHECK (type::text = ANY (ARRAY['FOOD'::character varying, 'BEVERAGE'::character varying, 'DESERT'::character varying]::text[])),
    CONSTRAINT products_unit_check CHECK (unit::text = ANY (ARRAY['G'::character varying, 'L'::character varying]::text[]))
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS product_catalog.products
    OWNER to ms_product_catalog_user;


-- Table: product_catalog.product_ingredients

DROP TABLE IF EXISTS product_catalog.product_ingredients;

CREATE TABLE IF NOT EXISTS product_catalog.product_ingredients
(
    amount double precision,
    version integer,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    id uuid NOT NULL,
    ingredient_id uuid NOT NULL,
    product_id uuid NOT NULL,
    CONSTRAINT product_ingredients_pkey PRIMARY KEY (id),
    CONSTRAINT product_ingredients__ing_fk FOREIGN KEY (ingredient_id)
    REFERENCES product_catalog.ingredients (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT product_ingredients__prd_fk FOREIGN KEY (product_id)
    REFERENCES product_catalog.products (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS product_catalog.product_ingredients
    OWNER to ms_product_catalog_user;
