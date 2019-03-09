{\rtf1\ansi\ansicpg1251\cocoartf1671\cocoasubrtf200
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 CREATE TABLE public.BOOK (\
  ID integer NOT NULL,\
  FIO varchar(50) NULL,\
  PHONE varchar(11) NULL,\
  CONSTRAINT PK PRIMARY KEY (ID)\
);\
\
CREATE SEQUENCE public.book_id_seq\
START WITH 1\
INCREMENT BY 1\
NO MINVALUE\
NO MAXVALUE\
CACHE 1;\
\
ALTER SEQUENCE public.book_id_seq OWNED BY public.BOOK.ID;\
\
ALTER TABLE ONLY public.BOOK ALTER COLUMN id SET DEFAULT nextval('public.book_id_seq'::regclass);}