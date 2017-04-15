CREATE TABLE TS_MENU (
  MENUID         VARCHAR(36)  NOT NULL PRIMARY KEY
  COMMENT '菜单ID',
  MENUNAME       VARCHAR(100)
  COMMENT '菜单名称',
  MENUTEXT       VARCHAR(200) NOT NULL
  COMMENT '菜单显示名称',
  MENUURL        VARCHAR(200)
  COMMENT '菜单所对应url路径',
  PARAMENTMENUID VARCHAR(36)  NOT NULL
  COMMENT '上级菜单ID',
  TARGET         VARCHAR(20)
  COMMENT '窗口显示位置',
  MENUVIEW       VARCHAR(100)
  COMMENT '菜单所对应视图路径',
  ICO            VARCHAR(200)
  COMMENT '菜单所对应图标路径',
  SXH            VARCHAR(6)   NOT NULL,
  ISVALID        VARCHAR(10)  NOT NULL
)
  DEFAULT CHARSET = utf8;

CREATE TABLE TS_ROLE (
  ROLEID   VARCHAR(20)  NOT NULL PRIMARY KEY
  COMMENT '角色ID',
  ROLEDESC VARCHAR(100) NOT NULL
  COMMENT '角色描述',
  FLAG     VARCHAR(10)  NOT NULL
  COMMENT '是否有效',
  USERCODE VARCHAR(36)
  COMMENT '编辑人员'
)
  DEFAULT CHARSET = utf8;

CREATE TABLE TS_ROLE_MENU (
  ROLEID VARCHAR(20) NOT NULL
  COMMENT '角色ID',
  MENUID VARCHAR(36) NOT NULL
  COMMENT '菜单ID',
  RIGHTS VARCHAR(2)  NOT NULL
  COMMENT '是否有权限',
  PRIMARY KEY (ROLEID, MENUID)
)
  DEFAULT CHARSET = utf8;

CREATE TABLE TBL_SYS_PARAMETER (
  PARMID    VARCHAR(20)  NOT NULL PRIMARY KEY
  COMMENT '参数ID',
  PARMSORT  NUMERIC(6)   NOT NULL
  COMMENT '参数序号',
  PARMDESC  VARCHAR(100) NOT NULL
  COMMENT '参数描述',
  PARMVALUE VARCHAR(250) NOT NULL
  COMMENT '参数值',
  PARMTYPE  NUMERIC(6)
  COMMENT '参数类型'
)
  DEFAULT CHARSET = utf8;

CREATE TABLE pup_code (
  ID           VARCHAR(36) NOT NULL PRIMARY KEY,
  LBBM         VARCHAR(60) NOT NULL,
  LBMC         VARCHAR(100) DEFAULT NULL,
  BM           VARCHAR(100) DEFAULT NULL,
  MC           VARCHAR(200) DEFAULT NULL,
  PYM          VARCHAR(100) DEFAULT NULL,
  EXT1         VARCHAR(50)  DEFAULT NULL,
  EXT2         VARCHAR(50)  DEFAULT NULL,
  EXT3         VARCHAR(50)  DEFAULT NULL,
  EXT4         VARCHAR(50)  DEFAULT NULL,
  FOR_STANDARD VARCHAR(50)  DEFAULT NULL,
  XYBZ         VARCHAR(1)   DEFAULT NULL,
  BZ           VARCHAR(200) DEFAULT NULL,
  SXH          INTEGER      DEFAULT NULL
)
  DEFAULT CHARSET = utf8;

CREATE TABLE pup_code_type (
  LBBM VARCHAR(60) NOT NULL PRIMARY KEY,
  LBMC VARCHAR(100) DEFAULT NULL,
  PYM  VARCHAR(50)  DEFAULT NULL,
  SXH  INTEGER      DEFAULT NULL
)
  DEFAULT CHARSET = utf8;

/*==============================================================*/
/* Table: cart                                                  */
/*==============================================================*/
CREATE TABLE cart
(
  buyer_id VARCHAR(36) NOT NULL,
  item_id  VARCHAR(36) NOT NULL,
  number   INT,
  PRIMARY KEY (buyer_id, item_id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
CREATE TABLE category
(
  category_id   VARCHAR(36) NOT NULL,
  category_name VARCHAR(15) NOT NULL,
  parent_id     VARCHAR(36),
  PRIMARY KEY (category_id)
);

/*==============================================================*/
/* Table: city                                                  */
/*==============================================================*/
CREATE TABLE city
(
  prov_num  NUMERIC(6, 0),
  city_num  NUMERIC(6, 0) NOT NULL,
  city_name VARCHAR(50)   NOT NULL,
  PRIMARY KEY (city_num)
);

/*==============================================================*/
/* Table: country                                               */
/*==============================================================*/
CREATE TABLE country
(
  country_num  NUMERIC(4, 0) NOT NULL,
  country_name VARCHAR(50)   NOT NULL,
  PRIMARY KEY (country_num)
);

/*==============================================================*/
/* Table: deliver                                               */
/*==============================================================*/
CREATE TABLE deliver
(
  item_id     VARCHAR(36) NOT NULL,
  delivery_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (item_id, delivery_id)
);

/*==============================================================*/
/* Table: delivery                                              */
/*==============================================================*/
CREATE TABLE delivery
(
  order_id            VARCHAR(36),
  delivery_id         VARCHAR(36) NOT NULL,
  delivery_price      FLOAT(8, 2),
  delivery_status     VARCHAR(64),
  delivery_details    VARCHAR(1024),
  delivery_company    VARCHAR(64),
  delivery_inquirynum VARCHAR(64),
  PRIMARY KEY (delivery_id)
);

/*==============================================================*/
/* Table: district                                              */
/*==============================================================*/
CREATE TABLE district
(
  city_num      NUMERIC(6, 0),
  district_num  NUMERIC(6, 0) NOT NULL,
  district_name VARCHAR(50)   NOT NULL,
  PRIMARY KEY (district_num)
);

/*==============================================================*/
/* Table: favorite                                             */
/*==============================================================*/
CREATE TABLE favorite
(
  buyer_id VARCHAR(36) NOT NULL,
  item_id  VARCHAR(36) NOT NULL,
  PRIMARY KEY (buyer_id, item_id)
);

/*==============================================================*/
/* Table: image                                                 */
/*==============================================================*/
CREATE TABLE image
(
  product_id VARCHAR(36),
  item_id    VARCHAR(36),
  image_id   VARCHAR(36)  NOT NULL,
  image_src  VARCHAR(255) NOT NULL,
  PRIMARY KEY (image_id)
);

/*==============================================================*/
/* Table: item                                                  */
/*==============================================================*/
CREATE TABLE item
(
  product_id VARCHAR(36),
  item_id    VARCHAR(36)   NOT NULL,
  price      DECIMAL(6)    NOT NULL,
  inventory  INT           NOT NULL,
  type       VARCHAR(1024) NOT NULL,
  size       VARCHAR(255)  NOT NULL,
  breakable  INT           NOT NULL,
  PRIMARY KEY (item_id)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
CREATE TABLE orders
(
  order_id          VARCHAR(36) NOT NULL,
  delivery_status   VARCHAR(64),
  created_time      DATETIME,
  paid_time         DATETIME,
  finished_time     DATETIME,
  good_price        FLOAT(8, 2),
  delivery_price    FLOAT(8, 2),
  good_discount     FLOAT(8, 2),
  delivery_discount FLOAT(8, 2),
  total_price       FLOAT(8, 2),
  comment_1         TEXT,
  comment_1_time    DATETIME,
  comment_2         TEXT,
  comment_2_time    DATETIME,
  payment_detail    TEXT,
  buyer_id          VARCHAR(36),
  buyer_address     VARCHAR(255),
  buyer_phonenum    VARCHAR(15),
  buyer_name        VARCHAR(20),
  seller_id         VARCHAR(36),
  seller_address    VARCHAR(255),
  sellert_phonenum  VARCHAR(15),
  seller_name       VARCHAR(20),
  PRIMARY KEY (order_id)
);

/*==============================================================*/
/* Table: pro_cat                                                */
/*==============================================================*/
CREATE TABLE pro_cat
(
  product_id  VARCHAR(36) NOT NULL,
  category_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (product_id, category_id)
);

/*==============================================================*/
/* Table: product         Modified:change advertisement varchar(51000) to text
/*==============================================================*/
CREATE TABLE product
(
  seller_id      VARCHAR(36)   NOT NULL,
  product_id     VARCHAR(36)   NOT NULL,
  product_number NUMERIC(8, 0) NOT NULL,
  product_name   VARCHAR(50)   NOT NULL,
  description    VARCHAR(1024),
  advertisement  TEXT,
  PRIMARY KEY (product_id)
);

/*==============================================================*/
/* Table: province                                              */
/*==============================================================*/
CREATE TABLE province
(
  country_num NUMERIC(4, 0),
  prov_num    NUMERIC(6, 0) NOT NULL,
  prov_name   VARCHAR(50)   NOT NULL,
  PRIMARY KEY (prov_num)
);

/*==============================================================*/
/* Table: shipaddress                                           */
/*==============================================================*/
CREATE TABLE shipaddress
(
  user_id        VARCHAR(36)   NOT NULL,
  addr_id        VARCHAR(36)   NOT NULL,
  country        VARCHAR(50),
  province       VARCHAR(50),
  city           VARCHAR(50),
  district       VARCHAR(50),
  zip            NUMERIC(6, 0) NOT NULL,
  buyer_address  VARCHAR(255)  NOT NULL,
  buyer_phonenum VARCHAR(15),
  buyer_name     VARCHAR(20),
  PRIMARY KEY (addr_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
CREATE TABLE user
(
  user_id               VARCHAR(36) NOT NULL,
  user_account          VARCHAR(50) NOT NULL,
  user_password         VARCHAR(36) NOT NULL,
  user_nickname         VARCHAR(20),
  user_realname         VARCHAR(20),
  user_phonenum         VARCHAR(15),
  user_email            VARCHAR(100),
  user_credit           INT         NOT NULL,
  user_points           INT         NOT NULL,
  user_seller_status    BOOL        NOT NULL,
  user_address          VARCHAR(512),
  user_idcardnum        VARCHAR(18),
  user_credit_as_seller INT,
  user_points_as_seller INT,
  user_key              VARCHAR(36) NOT NULL,
  PRIMARY KEY (user_id)
);

ALTER TABLE cart
  ADD CONSTRAINT `FK_in cart` FOREIGN KEY (buyer_id)
REFERENCES user (user_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE cart
  ADD CONSTRAINT `FK_in cart2` FOREIGN KEY (item_id)
REFERENCES item (item_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE city
  ADD CONSTRAINT `FK_province-city` FOREIGN KEY (prov_num)
REFERENCES province (prov_num)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE deliver
  ADD CONSTRAINT FK_deliver FOREIGN KEY (delivery_id)
REFERENCES delivery (delivery_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE deliver
  ADD CONSTRAINT FK_deliver2 FOREIGN KEY (item_id)
REFERENCES item (item_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE delivery
  ADD CONSTRAINT `FK_order-distribution` FOREIGN KEY (order_id)
REFERENCES orders (order_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE district
  ADD CONSTRAINT `FK_city-district` FOREIGN KEY (city_num)
REFERENCES city (city_num)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE favorite
  ADD CONSTRAINT FK_favorite FOREIGN KEY (buyer_id)
REFERENCES user (user_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE favorite
  ADD CONSTRAINT FK_favorite2 FOREIGN KEY (item_id)
REFERENCES item (item_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE image
  ADD CONSTRAINT FK_general FOREIGN KEY (product_id)
REFERENCES product (product_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE image
  ADD CONSTRAINT FK_specific FOREIGN KEY (item_id)
REFERENCES item (item_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE item
  ADD CONSTRAINT FK_SKU FOREIGN KEY (product_id)
REFERENCES product (product_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE orders
  ADD CONSTRAINT `FK_is made by` FOREIGN KEY (buyer_id)
REFERENCES user (user_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE orders
  ADD CONSTRAINT `FK_seller_status=true` FOREIGN KEY (seller_id)
REFERENCES user (user_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE pro_cat
  ADD CONSTRAINT `FK_belongs to` FOREIGN KEY (product_id)
REFERENCES product (product_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE pro_cat
  ADD CONSTRAINT `FK_belongs to2` FOREIGN KEY (category_id)
REFERENCES category (category_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE product
  ADD CONSTRAINT FK_seller_owns_product FOREIGN KEY (seller_id)
REFERENCES user (user_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE province
  ADD CONSTRAINT `FK_country-province` FOREIGN KEY (country_num)
REFERENCES country (country_num)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE shipaddress
  ADD CONSTRAINT `FK_owned by` FOREIGN KEY (user_id)
REFERENCES user (user_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

CREATE TABLE order_item (
  `order_item_id` VARCHAR(36) PRIMARY KEY NOT NULL,
  `order_id`      VARCHAR(36) DEFAULT NULL,
  `item_id`       VARCHAR(36) DEFAULT NULL,
  `item_num`      INT         DEFAULT NULL
);

# CREATE TABLE item_comment(
#   `COMMENT_ID` VARCHAR(36) NOT NULL PRIMARY KEY ,
#   `item_id` VARCHAR(36) NOT NULL ,
#   `size` VARCHAR(255) NOT NULL ,
#   `product_id` VARCHAR(36) NOT NULL ,
#   `user_id` VARCHAR(36) NULL ,
#   `comment1_content` TEXT NULL ,
#   `comment1_time` DATETIME NULL ,
#   `comment2_content` TEXT NULL ,
#   `comment2_time` DATETIME,
#   FOREIGN KEY (`item_id`) REFERENCES item (`item_id`),
#   FOREIGN KEY (`product_id`) REFERENCES product (`product_id`),
#   FOREIGN KEY (`user_id`) REFERENCES user (`user_id`)
# );

