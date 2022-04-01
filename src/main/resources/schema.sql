-- public."user" definition

-- Drop table
DROP TABLE IF EXISTS public."user";

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	id int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	"name" varchar NOT NULL,
	createddate date NOT NULL DEFAULT CURRENT_DATE,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

-- public.store definition

-- Drop table
DROP TABLE IF EXISTS public.store;
-- DROP TABLE public.store;

CREATE TABLE public.store (
	id int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	"name" varchar NOT NULL,
	category varchar NOT NULL,
	user_id int8 NOT NULL
);


-- public.store foreign keys

ALTER TABLE public.store ADD CONSTRAINT store_fk FOREIGN KEY (user_id) REFERENCES public."user"(id);