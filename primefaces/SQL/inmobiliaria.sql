--------------------------------------------------------
-- Archivo creado  - martes-agosto-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence CARACTERISTICAS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."CARACTERISTICAS_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CARACTXPROPIEDAD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."CARACTXPROPIEDAD_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CIUDAD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."CIUDAD_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 5 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence IMAGENES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."IMAGENES_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 7 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PROPIEDADES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."PROPIEDADES_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 19 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TIPODEOPERACION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."TIPODEOPERACION_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TIPODEPROPIEDAD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."TIPODEPROPIEDAD_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USUARIOS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."USUARIOS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999 INCREMENT BY 1 START WITH 4 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence ZONAS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TP_DBA"."ZONAS_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table CARACTERISTICAS
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."CARACTERISTICAS" 
   (	"CARACTERISTICA_ID" NUMBER(8,2), 
	"DESCRIPCION" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CARACTERISTICASPORPROPIEDAD
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."CARACTERISTICASPORPROPIEDAD" 
   (	"PROPIEDAD_ID" NUMBER(8,2), 
	"CARACTERISTICA_ID" NUMBER(8,2)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CATEGORIAPROPIEDAD
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."CATEGORIAPROPIEDAD" 
   (	"CATEGORIA_ID" NUMBER(8,2), 
	"DESCRIPCION" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CIUDAD
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."CIUDAD" 
   (	"CIUDAD_ID" NUMBER(8,2), 
	"NOMBRE" VARCHAR2(60 BYTE), 
	"ZONA_ID" NUMBER(8,2)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table IMAGENES
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."IMAGENES" 
   (	"IMAGEN_ID" NUMBER(8,2), 
	"IMAGE_PATH" VARCHAR2(500 BYTE), 
	"PROPIEDAD_ID" NUMBER(8,2), 
	"ACTIVE" VARCHAR2(1 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PROPIEDADES
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."PROPIEDADES" 
   (	"PROPIEDAD_ID" NUMBER(8,2), 
	"DIRECCION" VARCHAR2(60 BYTE), 
	"DESCRIPCION" VARCHAR2(500 BYTE), 
	"AMBIENTES" NUMBER(8,2), 
	"BANIOS" NUMBER(8,2), 
	"SUPERFICIE_CUBIERTA" NUMBER(8,2), 
	"PRECIO" NUMBER(12,2), 
	"TIPO_DE_OPERACION_ID" NUMBER(8,2), 
	"TIPO_DE_PROPIEDAD_ID" NUMBER(8,2), 
	"ACTIVE" VARCHAR2(1 BYTE), 
	"CIUDAD_ID" NUMBER(8,2), 
	"HABITACIONES" NUMBER(8,2), 
	"SUPERFICIE_TOTAL" NUMBER(8,2), 
	"FECHA_DE_CONSTRUCCION" DATE, 
	"LONGITUD" FLOAT(126), 
	"LATITUD" FLOAT(126), 
	"CREATE_DATE" DATE, 
	"CREATE_USER" VARCHAR2(50 BYTE), 
	"UPDATE_USER" VARCHAR2(50 BYTE), 
	"UPDATE_DATE" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

   COMMENT ON COLUMN "TP_DBA"."PROPIEDADES"."ACTIVE" IS 'True = ''Y'' False = ''N''';
--------------------------------------------------------
--  DDL for Table TIPODEOPERACION
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."TIPODEOPERACION" 
   (	"TIPO_DE_ORACION_ID" NUMBER(8,2), 
	"DESCRIPCION" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TIPODEPROPIEDAD
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."TIPODEPROPIEDAD" 
   (	"TIPO_DE_PROPIEDAD_ID" NUMBER(8,2), 
	"DESCRIPCION" VARCHAR2(25 BYTE), 
	"CATEGORIA_PROPIEDAD_ID" NUMBER(8,2), 
	"CREATE_DATE" DATE, 
	"CREATE_USER" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USUARIOS
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."USUARIOS" 
   (	"USUARIO_ID" NUMBER, 
	"USUARIO" VARCHAR2(40 BYTE), 
	"PASSWORD" VARCHAR2(30 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ZONAS
--------------------------------------------------------

  CREATE TABLE "TP_DBA"."ZONAS" 
   (	"ZONA_ID" NUMBER(8,2), 
	"DESCRIPCION" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into TP_DBA.CARACTERISTICAS
SET DEFINE OFF;
REM INSERTING into TP_DBA.CARACTERISTICASPORPROPIEDAD
SET DEFINE OFF;
REM INSERTING into TP_DBA.CATEGORIAPROPIEDAD
SET DEFINE OFF;
Insert into TP_DBA.CATEGORIAPROPIEDAD (CATEGORIA_ID,DESCRIPCION) values ('1','Residencial');
Insert into TP_DBA.CATEGORIAPROPIEDAD (CATEGORIA_ID,DESCRIPCION) values ('2','Comercial');
REM INSERTING into TP_DBA.CIUDAD
SET DEFINE OFF;
Insert into TP_DBA.CIUDAD (CIUDAD_ID,NOMBRE,ZONA_ID) values ('1','Pilar',null);
Insert into TP_DBA.CIUDAD (CIUDAD_ID,NOMBRE,ZONA_ID) values ('2','San Miguel',null);
Insert into TP_DBA.CIUDAD (CIUDAD_ID,NOMBRE,ZONA_ID) values ('4','Jose C. Paz',null);
Insert into TP_DBA.CIUDAD (CIUDAD_ID,NOMBRE,ZONA_ID) values ('3','Gral. Pacheco',null);
REM INSERTING into TP_DBA.IMAGENES
SET DEFINE OFF;
Insert into TP_DBA.IMAGENES (IMAGEN_ID,IMAGE_PATH,PROPIEDAD_ID,ACTIVE) values ('1','depto1_1.png','7','Y');
Insert into TP_DBA.IMAGENES (IMAGEN_ID,IMAGE_PATH,PROPIEDAD_ID,ACTIVE) values ('2','depto1_2.png','7','Y');
Insert into TP_DBA.IMAGENES (IMAGEN_ID,IMAGE_PATH,PROPIEDAD_ID,ACTIVE) values ('3','depto1_3.png','7','Y');
Insert into TP_DBA.IMAGENES (IMAGEN_ID,IMAGE_PATH,PROPIEDAD_ID,ACTIVE) values ('4','depto1_4.png','7','Y');
Insert into TP_DBA.IMAGENES (IMAGEN_ID,IMAGE_PATH,PROPIEDAD_ID,ACTIVE) values ('5','depto1_5.png','7','Y');
Insert into TP_DBA.IMAGENES (IMAGEN_ID,IMAGE_PATH,PROPIEDAD_ID,ACTIVE) values ('6','depto1_6.png','7','Y');
REM INSERTING into TP_DBA.PROPIEDADES
SET DEFINE OFF;
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('7','necochea 200','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','2','1','40','4500','2','2','Y','1','1','40',to_date('02/05/2016','DD/MM/RRRR'),'-58,904385','-34,45474',to_date('04/07/2016','DD/MM/RRRR'),'rciccone','rciccone',to_date('09/07/2016','DD/MM/RRRR'));
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('12','necochea 400','dsfdssdfsdfsd','3','1','60','700000','1','2','Y','1','2','60',to_date('08/06/2016','DD/MM/RRRR'),'-58,901554','-34,45329',to_date('04/07/2016','DD/MM/RRRR'),'rciccone',null,null);
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('15','soler 400','aaaaaaaaaaaaaa','3','1','79','5500','2','1','Y','1','2','79',to_date('09/05/2016','DD/MM/RRRR'),'-58,90038','-34,450096',to_date('09/07/2016','DD/MM/RRRR'),'rciccone',null,null);
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('16','av tratado del pilar 500','ddddddddd','3','1','78','6000','2','1','Y','1','2','78',to_date('03/07/2016','DD/MM/RRRR'),'-58,906334','-34,450253',to_date('09/07/2016','DD/MM/RRRR'),'rciccone',null,null);
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('13','paunero 1400','esta es una casa de pruebaaaaa','5','2','160','10000','2','1','Y','2','3','180',to_date('01/07/2016','DD/MM/RRRR'),'-58,835373','-34,447117',to_date('04/07/2016','DD/MM/RRRR'),'rciccone',null,null);
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('17','Pueyrredon 1500','una casa vieja VIEJA VIEJAAAAAA','4','1','80','800000','1','1','Y','4','2','80',to_date('01/07/2016','DD/MM/RRRR'),'-58,74432','-34,522827',to_date('14/07/2016','DD/MM/RRRR'),'rciccone','rciccone',to_date('14/07/2016','DD/MM/RRRR'));
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('2','necochea 705','mdksmfdsnfkjnds','2','2','1','22222','2','2','Y','1','1','1',to_date('06/06/2016','DD/MM/RRRR'),'-58,718136','-34,537777',to_date('04/07/2016','DD/MM/RRRR'),'rciccone',null,null);
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('5','Av. Presidente Peron 2095','San miguel centro - Esta prop fue editada','3','1','40','900000','1','2','Y','2','1','40',to_date('01/06/2016','DD/MM/RRRR'),'-58,718136','-34,537777',to_date('04/07/2016','DD/MM/RRRR'),'rciccone','rciccone',to_date('14/07/2016','DD/MM/RRRR'));
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('18','buenos aires 150','es una casa muy linda modificada','4','1','130','1250000','1','1','Y','3','3','130',to_date('01/01/2007','DD/MM/RRRR'),'-58,625416','-34,45401',to_date('14/07/2016','DD/MM/RRRR'),'pmartinez','pmartinez',to_date('14/07/2016','DD/MM/RRRR'));
Insert into TP_DBA.PROPIEDADES (PROPIEDAD_ID,DIRECCION,DESCRIPCION,AMBIENTES,BANIOS,SUPERFICIE_CUBIERTA,PRECIO,TIPO_DE_OPERACION_ID,TIPO_DE_PROPIEDAD_ID,ACTIVE,CIUDAD_ID,HABITACIONES,SUPERFICIE_TOTAL,FECHA_DE_CONSTRUCCION,LONGITUD,LATITUD,CREATE_DATE,CREATE_USER,UPDATE_USER,UPDATE_DATE) values ('9','paunero 2500','casa prueba 2','2','1','50','5000','2','1','Y','2','1','50',to_date('07/06/2016','DD/MM/RRRR'),'-58,728592','-34,528934',to_date('04/07/2016','DD/MM/RRRR'),'rciccone',null,null);
REM INSERTING into TP_DBA.TIPODEOPERACION
SET DEFINE OFF;
Insert into TP_DBA.TIPODEOPERACION (TIPO_DE_ORACION_ID,DESCRIPCION) values ('1','Venta');
Insert into TP_DBA.TIPODEOPERACION (TIPO_DE_ORACION_ID,DESCRIPCION) values ('2','Alquiler');
REM INSERTING into TP_DBA.TIPODEPROPIEDAD
SET DEFINE OFF;
Insert into TP_DBA.TIPODEPROPIEDAD (TIPO_DE_PROPIEDAD_ID,DESCRIPCION,CATEGORIA_PROPIEDAD_ID,CREATE_DATE,CREATE_USER) values ('1','Casa','1',null,null);
Insert into TP_DBA.TIPODEPROPIEDAD (TIPO_DE_PROPIEDAD_ID,DESCRIPCION,CATEGORIA_PROPIEDAD_ID,CREATE_DATE,CREATE_USER) values ('2','Departamento','1',null,null);
REM INSERTING into TP_DBA.USUARIOS
SET DEFINE OFF;
Insert into TP_DBA.USUARIOS (USUARIO_ID,USUARIO,PASSWORD) values ('3','usertest','test');
Insert into TP_DBA.USUARIOS (USUARIO_ID,USUARIO,PASSWORD) values ('1','rciccone','pass1234');
Insert into TP_DBA.USUARIOS (USUARIO_ID,USUARIO,PASSWORD) values ('2','pmartinez','admin123');
REM INSERTING into TP_DBA.ZONAS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_CARACTERISTICAS
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_CARACTERISTICAS" ON "TP_DBA"."CARACTERISTICAS" ("CARACTERISTICA_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CARACTERISTICASPORPROPIEDAD
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_CARACTERISTICASPORPROPIEDAD" ON "TP_DBA"."CARACTERISTICASPORPROPIEDAD" ("PROPIEDAD_ID", "CARACTERISTICA_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CATEGORIAPROPIEDAD
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_CATEGORIAPROPIEDAD" ON "TP_DBA"."CATEGORIAPROPIEDAD" ("CATEGORIA_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CIUDAD
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_CIUDAD" ON "TP_DBA"."CIUDAD" ("CIUDAD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_IMAGENES
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_IMAGENES" ON "TP_DBA"."IMAGENES" ("IMAGEN_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PROPIEDADES
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_PROPIEDADES" ON "TP_DBA"."PROPIEDADES" ("PROPIEDAD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TIPODEOPERACION
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_TIPODEOPERACION" ON "TP_DBA"."TIPODEOPERACION" ("TIPO_DE_ORACION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TIPODEPROPIEDAD
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_TIPODEPROPIEDAD" ON "TP_DBA"."TIPODEPROPIEDAD" ("TIPO_DE_PROPIEDAD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ZONAS
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."PK_ZONAS" ON "TP_DBA"."ZONAS" ("ZONA_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USUARIOS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."USUARIOS_PK" ON "TP_DBA"."USUARIOS" ("USUARIO_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USUARIOS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "TP_DBA"."USUARIOS_UK1" ON "TP_DBA"."USUARIOS" ("USUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CARACTERISTICAS
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."CARACTERISTICAS" ADD CONSTRAINT "PK_CARACTERISTICAS" PRIMARY KEY ("CARACTERISTICA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."CARACTERISTICAS" MODIFY ("CARACTERISTICA_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."CARACTERISTICAS" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CARACTERISTICASPORPROPIEDAD
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."CARACTERISTICASPORPROPIEDAD" ADD CONSTRAINT "PK_CARACTERISTICASPORPROPIEDAD" PRIMARY KEY ("PROPIEDAD_ID", "CARACTERISTICA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."CARACTERISTICASPORPROPIEDAD" MODIFY ("PROPIEDAD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."CARACTERISTICASPORPROPIEDAD" MODIFY ("CARACTERISTICA_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CATEGORIAPROPIEDAD
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."CATEGORIAPROPIEDAD" ADD CONSTRAINT "PK_CATEGORIAPROPIEDAD" PRIMARY KEY ("CATEGORIA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."CATEGORIAPROPIEDAD" MODIFY ("CATEGORIA_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."CATEGORIAPROPIEDAD" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CIUDAD
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."CIUDAD" ADD CONSTRAINT "PK_CIUDAD" PRIMARY KEY ("CIUDAD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."CIUDAD" MODIFY ("CIUDAD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."CIUDAD" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table IMAGENES
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."IMAGENES" ADD CONSTRAINT "PK_IMAGENES" PRIMARY KEY ("IMAGEN_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."IMAGENES" MODIFY ("IMAGEN_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."IMAGENES" MODIFY ("IMAGE_PATH" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."IMAGENES" MODIFY ("PROPIEDAD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."IMAGENES" MODIFY ("ACTIVE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROPIEDADES
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."PROPIEDADES" ADD CONSTRAINT "PK_PROPIEDADES" PRIMARY KEY ("PROPIEDAD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("PROPIEDAD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("DIRECCION" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("AMBIENTES" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("BANIOS" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("SUPERFICIE_CUBIERTA" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("TIPO_DE_OPERACION_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("ACTIVE" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" MODIFY ("CIUDAD_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPODEOPERACION
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."TIPODEOPERACION" ADD CONSTRAINT "PK_TIPODEOPERACION" PRIMARY KEY ("TIPO_DE_ORACION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."TIPODEOPERACION" MODIFY ("TIPO_DE_ORACION_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."TIPODEOPERACION" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPODEPROPIEDAD
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."TIPODEPROPIEDAD" ADD CONSTRAINT "PK_TIPODEPROPIEDAD" PRIMARY KEY ("TIPO_DE_PROPIEDAD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."TIPODEPROPIEDAD" MODIFY ("TIPO_DE_PROPIEDAD_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."TIPODEPROPIEDAD" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."TIPODEPROPIEDAD" MODIFY ("CATEGORIA_PROPIEDAD_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."USUARIOS" MODIFY ("USUARIO_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."USUARIOS" MODIFY ("USUARIO" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."USUARIOS" MODIFY ("PASSWORD" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."USUARIOS" ADD CONSTRAINT "USUARIOS_PK" PRIMARY KEY ("USUARIO_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."USUARIOS" ADD CONSTRAINT "USUARIOS_UK1" UNIQUE ("USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ZONAS
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."ZONAS" ADD CONSTRAINT "PK_ZONAS" PRIMARY KEY ("ZONA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TP_DBA"."ZONAS" MODIFY ("ZONA_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TP_DBA"."ZONAS" MODIFY ("DESCRIPCION" NOT NULL ENABLE);

--------------------------------------------------------
--  Ref Constraints for Table CARACTERISTICASPORPROPIEDAD
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."CARACTERISTICASPORPROPIEDAD" ADD CONSTRAINT "FK_CARACXPROP_CARACTERISTICAS" FOREIGN KEY ("CARACTERISTICA_ID")
	  REFERENCES "TP_DBA"."CARACTERISTICAS" ("CARACTERISTICA_ID") ENABLE;
 
  ALTER TABLE "TP_DBA"."CARACTERISTICASPORPROPIEDAD" ADD CONSTRAINT "FK_CARACXPROP_PROPIEDADES" FOREIGN KEY ("PROPIEDAD_ID")
	  REFERENCES "TP_DBA"."PROPIEDADES" ("PROPIEDAD_ID") ENABLE;

--------------------------------------------------------
--  Ref Constraints for Table CIUDAD
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."CIUDAD" ADD CONSTRAINT "FK_CIUDAD_ZONAS" FOREIGN KEY ("ZONA_ID")
	  REFERENCES "TP_DBA"."ZONAS" ("ZONA_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table IMAGENES
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."IMAGENES" ADD CONSTRAINT "FK_IMAGENES_PROPIEDADES" FOREIGN KEY ("PROPIEDAD_ID")
	  REFERENCES "TP_DBA"."PROPIEDADES" ("PROPIEDAD_ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PROPIEDADES
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."PROPIEDADES" ADD CONSTRAINT "FK_PROPIEDADES_CIUDAD" FOREIGN KEY ("CIUDAD_ID")
	  REFERENCES "TP_DBA"."CIUDAD" ("CIUDAD_ID") ENABLE;
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" ADD CONSTRAINT "FK_PROPIEDADES_TIPODEOPERACION" FOREIGN KEY ("TIPO_DE_OPERACION_ID")
	  REFERENCES "TP_DBA"."TIPODEOPERACION" ("TIPO_DE_ORACION_ID") ENABLE;
 
  ALTER TABLE "TP_DBA"."PROPIEDADES" ADD CONSTRAINT "FK_PROPIEDADES_TIPODEPROPIEDAD" FOREIGN KEY ("TIPO_DE_PROPIEDAD_ID")
	  REFERENCES "TP_DBA"."TIPODEPROPIEDAD" ("TIPO_DE_PROPIEDAD_ID") ENABLE;

--------------------------------------------------------
--  Ref Constraints for Table TIPODEPROPIEDAD
--------------------------------------------------------

  ALTER TABLE "TP_DBA"."TIPODEPROPIEDAD" ADD CONSTRAINT "FK_TIPODEPROP_CATEGORIAPROP" FOREIGN KEY ("CATEGORIA_PROPIEDAD_ID")
	  REFERENCES "TP_DBA"."CATEGORIAPROPIEDAD" ("CATEGORIA_ID") ENABLE;


--------------------------------------------------------
--  DDL for Package ABM_INMOBILIARIA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "TP_DBA"."ABM_INMOBILIARIA" 
AS 
PROCEDURE insert_propiedad(direccion IN VARCHAR2,
descripcion IN VARCHAR2,
ambientes IN NUMBER,
banios IN NUMBER,
superficie_cubierta IN NUMBER,
precio IN NUMBER,
tipo_de_operacion_id IN NUMBER,
tipo_de_propiedad_id IN NUMBER,
active IN VARCHAR2,
ciudad_id IN NUMBER,
habitaciones IN NUMBER,
superficie_total IN NUMBER,
fecha_de_construccion IN DATE,
longitud IN FLOAT,
latitud IN FLOAT,
create_date IN DATE,
create_user IN VARCHAR2,
update_date IN DATE,
update_user IN VARCHAR2); 

PROCEDURE update_propiedad(prop_id IN NUMBER,v_direccion IN VARCHAR2,
v_descripcion IN VARCHAR2,
v_ambientes IN NUMBER,
v_banios IN NUMBER,
v_superficie_cubierta IN NUMBER,
v_precio IN NUMBER,
v_tipo_de_operacion_id IN NUMBER,
v_tipo_de_propiedad_id IN NUMBER,
v_active IN VARCHAR2,
v_ciudad_id IN NUMBER,
v_habitaciones IN NUMBER,
v_superficie_total IN NUMBER,
v_fecha_de_construccion IN DATE,
v_longitud IN FLOAT,
v_latitud IN FLOAT,
v_create_date IN DATE,
v_create_user IN VARCHAR2,
v_update_date IN DATE,
v_update_user IN VARCHAR2); 

PROCEDURE save_usuario(usuario IN VARCHAR2, password IN VARCHAR2);
PROCEDURE save_ciudad(ciudad IN VARCHAR2);


END abm_inmobiliaria;

/

  GRANT EXECUTE ON "TP_DBA"."ABM_INMOBILIARIA" TO "TP_USUARIOAPP";
--------------------------------------------------------
--  DDL for Package CONSULTAS_INMOBILIARIA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "TP_DBA"."CONSULTAS_INMOBILIARIA" 
AS 
PROCEDURE get_props_by_operacion(op IN NUMBER, props OUT SYS_REFCURSOR);
PROCEDURE get_prop_by_id(id IN NUMBER, prop OUT SYS_REFCURSOR);
PROCEDURE get_ciudad_by_id(id in NUMBER, ciudad OUT SYS_REFCURSOR);
PROCEDURE get_tipo_de_op_by_id(id in NUMBER, tipoOp OUT SYS_REFCURSOR);
PROCEDURE get_tipo_de_prop_by_id(id in NUMBER, tipoProp OUT SYS_REFCURSOR);
PROCEDURE get_props(props OUT SYS_REFCURSOR);
PROCEDURE get_ciudades(ciudades OUT SYS_REFCURSOR);
FUNCTION login_user(usr IN VARCHAR, psswd IN VARCHAR) return number;
PROCEDURE get_imagenes_by_prop(id IN NUMBER, imagenes OUT SYS_REFCURSOR);
PROCEDURE get_tipo_de_operaciones(operaciones OUT SYS_REFCURSOR);
PROCEDURE get_tipo_de_propiedades(tiposDeProp OUT SYS_REFCURSOR);
FUNCTION existe_user(usr IN VARCHAR) return number;
END consultas_inmobiliaria;

/

  GRANT EXECUTE ON "TP_DBA"."CONSULTAS_INMOBILIARIA" TO "TP_USUARIOAPP";
--------------------------------------------------------
--  DDL for Package Body ABM_INMOBILIARIA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "TP_DBA"."ABM_INMOBILIARIA" 
AS 
PROCEDURE insert_propiedad(direccion             IN VARCHAR2, 
                           descripcion           IN VARCHAR2, 
                           ambientes             IN NUMBER, 
                           banios                IN NUMBER, 
                           superficie_cubierta   IN NUMBER, 
                           precio                IN NUMBER, 
                           tipo_de_operacion_id  IN NUMBER, 
                           tipo_de_propiedad_id  IN NUMBER, 
                           active                IN VARCHAR2, 
                           ciudad_id             IN NUMBER, 
                           habitaciones          IN NUMBER, 
                           superficie_total      IN NUMBER, 
                           fecha_de_construccion IN DATE, 
                           longitud              IN FLOAT, 
                           latitud               IN FLOAT, 
                           create_date           IN DATE, 
                           create_user           IN VARCHAR2, 
                           update_date           IN DATE, 
                           update_user           IN VARCHAR2)
IS 
BEGIN 
  INSERT INTO propiedades VALUES 
              ( 
                          PROPIEDADES_SEQ.NEXTVAL, 
                          direccion, 
                          descripcion, 
                          ambientes, 
                          banios, 
                          superficie_cubierta, 
                          precio, 
                          tipo_de_operacion_id, 
                          tipo_de_propiedad_id, 
                          active, 
                          ciudad_id, 
                          habitaciones,
                          superficie_total,
                          fecha_de_construccion,
                          longitud,
                          latitud,
                          create_date, 
                          create_user, 
                          update_user, 
                          update_date 
              );
EXCEPTION 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm);
END insert_propiedad; 

PROCEDURE update_propiedad(prop_id               IN NUMBER,
                           v_direccion             IN VARCHAR2, 
                           v_descripcion           IN VARCHAR2, 
                           v_ambientes             IN NUMBER, 
                           v_banios                IN NUMBER, 
                           v_superficie_cubierta   IN NUMBER, 
                           v_precio                IN NUMBER, 
                           v_tipo_de_operacion_id  IN NUMBER, 
                           v_tipo_de_propiedad_id  IN NUMBER, 
                           v_active                IN VARCHAR2, 
                           v_ciudad_id             IN NUMBER, 
                           v_habitaciones          IN NUMBER, 
                           v_superficie_total      IN NUMBER, 
                           v_fecha_de_construccion IN DATE, 
                           v_longitud              IN FLOAT, 
                           v_latitud               IN FLOAT, 
                           v_create_date           IN DATE, 
                           v_create_user           IN VARCHAR2, 
                           v_update_date           IN DATE, 
                           v_update_user           IN VARCHAR2)
IS 
BEGIN 
  UPDATE propiedades set direccion  = v_direccion, descripcion = v_descripcion, ambientes = v_ambientes,
  banios = v_banios, superficie_cubierta = v_superficie_cubierta, precio = v_precio, 
  tipo_de_operacion_id = v_tipo_de_operacion_id, tipo_de_propiedad_id = v_tipo_de_propiedad_id,
  active = v_active, ciudad_id = v_ciudad_id, habitaciones = v_habitaciones, superficie_total = v_superficie_total,
  fecha_de_construccion = v_fecha_de_construccion, longitud = v_longitud, latitud = v_latitud,
  create_date = v_create_date, create_user = v_create_user, update_date = v_update_date,
  update_user = v_update_user
  where propiedad_id = prop_id;
EXCEPTION 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm);
END update_propiedad; 


PROCEDURE save_usuario(usuario IN VARCHAR2, password IN VARCHAR2)
IS
BEGIN
    INSERT into usuarios values(USUARIOS_SEQ.NEXTVAL,usuario,password);
    EXCEPTION 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm);
END save_usuario; 


PROCEDURE save_ciudad(ciudad IN VARCHAR2)
IS
BEGIN
    INSERT into ciudad values(CIUDAD_SEQ.NEXTVAL,ciudad,null);
    EXCEPTION 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm);
END save_ciudad; 

END abm_inmobiliaria;

/

  GRANT EXECUTE ON "TP_DBA"."ABM_INMOBILIARIA" TO "TP_USUARIOAPP";
--------------------------------------------------------
--  DDL for Package Body CONSULTAS_INMOBILIARIA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "TP_DBA"."CONSULTAS_INMOBILIARIA" 
AS 
PROCEDURE get_props_by_operacion(op IN NUMBER, props OUT SYS_REFCURSOR) 
IS 
  v_op NUMBER:=op;
BEGIN
  open props for 
  select propiedad_id,direccion,descripcion,ambientes,banios,superficie_cubierta,precio,
        tipo_de_operacion_id,tipo_de_propiedad_id,active,ciudad_id,habitaciones,superficie_total,
        fecha_de_construccion,longitud,latitud,create_date,create_user,update_user,update_date
        from propiedades where tipo_de_operacion_id = v_op and active = 'Y';
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontro ninguna propiedad: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_props_by_operacion; 

PROCEDURE get_prop_by_id(id IN NUMBER, prop OUT SYS_REFCURSOR) 
IS 
  v_id NUMBER:=id;
BEGIN
  open prop for 
  select propiedad_id,direccion,descripcion,ambientes,banios,superficie_cubierta,precio,
        tipo_de_operacion_id,tipo_de_propiedad_id,active,ciudad_id,habitaciones,superficie_total,
        fecha_de_construccion,longitud,latitud,create_date,create_user,update_user,update_date
        from propiedades where propiedad_id = v_id;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontro ninguna propiedad: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_prop_by_id; 

PROCEDURE get_ciudad_by_id(id IN NUMBER, ciudad OUT SYS_REFCURSOR) 
IS 
  v_id NUMBER:=id;
BEGIN
  open ciudad for 
  select ciudad_id,nombre,zona_id
        from ciudad where ciudad_id = v_id;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontro la ciudad: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_ciudad_by_id; 

PROCEDURE get_tipo_de_op_by_id(id IN NUMBER, tipoOp OUT SYS_REFCURSOR) 
IS 
  v_id NUMBER:=id;
BEGIN
  open tipoOp for 
  select tipo_de_oracion_id, descripcion
        from tipodeoperacion where tipo_de_oracion_id = v_id;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontro ningun tipo de operacion: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_tipo_de_op_by_id; 

PROCEDURE get_tipo_de_prop_by_id(id IN NUMBER, tipoProp OUT SYS_REFCURSOR) 
IS 
  v_id NUMBER:=id;
BEGIN
  open tipoProp for 
  select tipo_de_propiedad_id, descripcion, categoria_propiedad_id
        from tipodepropiedad where tipo_de_propiedad_id = v_id;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontro ningun tipo de propiedad: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_tipo_de_prop_by_id; 

PROCEDURE get_props(props OUT SYS_REFCURSOR) 
IS 
BEGIN
  open props for 
  select propiedad_id,direccion,descripcion,ambientes,banios,superficie_cubierta,precio,
        tipo_de_operacion_id,tipo_de_propiedad_id,active,ciudad_id,habitaciones,superficie_total,
        fecha_de_construccion,longitud,latitud,create_date,create_user,update_user,update_date
        from propiedades where active = 'Y';
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontro ninguna propiedad: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_props; 

PROCEDURE get_ciudades(ciudades OUT SYS_REFCURSOR) 
IS 
BEGIN
  open ciudades for 
   select ciudad_id,nombre,zona_id
        from ciudad;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontraron ciudades: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_ciudades; 

FUNCTION login_user(usr IN VARCHAR, psswd IN VARCHAR) return number
IS
  existe Number;
BEGIN 
    select count(*) into existe from usuarios where usuarios.usuario = usr
    and usuarios.password = psswd;
    return existe;
END login_user;


PROCEDURE get_imagenes_by_prop(id IN NUMBER,imagenes OUT SYS_REFCURSOR) 
IS 
  v_id NUMBER:=id;
BEGIN 
  open imagenes for 
   select imagen_id,image_path,active from imagenes
        where active ='Y' and propiedad_id = v_id;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontraron imagenes: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_imagenes_by_prop; 


PROCEDURE get_tipo_de_operaciones(operaciones OUT SYS_REFCURSOR) 
IS 
BEGIN
  open operaciones for 
   select tipo_de_oracion_id,descripcion
        from tipodeoperacion;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontraron tipo de operaciones: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_tipo_de_operaciones; 

PROCEDURE get_tipo_de_propiedades(tiposDeProp OUT SYS_REFCURSOR) 
IS 
BEGIN
  open tiposDeProp for 
   select tipo_de_propiedad_id,descripcion, create_date, create_user
        from tipodepropiedad;
EXCEPTION 
WHEN no_data_found THEN 
  dbms_output.put_line('No se encontraron tipo de propiedades: '); 
WHEN OTHERS THEN 
  dbms_output.put_line('Error: '+sqlerrm); 
END get_tipo_de_propiedades; 


FUNCTION existe_user(usr IN VARCHAR) return number
IS
  existe Number;
BEGIN 
    select count(*) into existe from usuarios where usuarios.usuario = usr;
    return existe;
END existe_user;


END consultas_inmobiliaria;

/

  GRANT EXECUTE ON "TP_DBA"."CONSULTAS_INMOBILIARIA" TO "TP_USUARIOAPP";
--------------------------------------------------------
--  DDL for Synonymn DBMS_OUTPUT
--------------------------------------------------------

  CREATE OR REPLACE PUBLIC SYNONYM "DBMS_OUTPUT" FOR "SYS"."DBMS_OUTPUT";
