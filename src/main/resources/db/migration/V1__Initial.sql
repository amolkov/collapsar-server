CREATE TABLE public.apod (
    id SERIAL PRIMARY KEY NOT NULL,
    copyright TEXT,
    date DATE,
    explanation TEXT,
    media_type TEXT,
    title TEXT,
    url TEXT,
    hd_url TEXT
);