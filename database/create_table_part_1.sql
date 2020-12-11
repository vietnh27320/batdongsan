use estate32020module1part1;

CREATE TABLE role(
    id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

CREATE TABLE user(
    id bigint NOT NULL PRIMARY KEY auto_increment,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    status int NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

CREATE TABLE user_role(
	id bigint NOT NULL PRIMARY KEY auto_increment,
	roleid bigint NOT NULL,
    userid bigint NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

-- user n - n role
ALTER TABLE user_role ADD CONSTRAINT fk_user_role FOREIGN KEY (userid) REFERENCES user(id);
ALTER TABLE user_role ADD CONSTRAINT fk_role_user FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE customer(
    id bigint NOT NULL PRIMARY KEY auto_increment,
    fullname VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

-- user n - n customer
CREATE TABLE assignmentcustomer(
    id bigint NOT NULL PRIMARY KEY auto_increment,
    staffid bigint NOT NULL,
    customerid bigint NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

ALTER TABLE assignmentcustomer ADD CONSTRAINT fk_user_customer FOREIGN KEY (staffid) REFERENCES user(id);
ALTER TABLE assignmentcustomer ADD CONSTRAINT fk_customer_user FOREIGN KEY (customerid) REFERENCES customer(id);

CREATE TABLE building(
    id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(255) NULL,
	ward VARCHAR(255) NULL,
	district VARCHAR(255) NULL,
    structure VARCHAR(255) NULL,
    numberofbasement int NULL,
    floorarea int NULL,
	direction VARCHAR(255) NULL,
    level VARCHAR(255) NULL,
    rentprice int NOT NULL,
	rentpricedescription TEXT NULL,
	servicefee VARCHAR(255) NULL,
	carfee VARCHAR(255) NULL,
	motofee VARCHAR(255) NULL,
    overtimefee VARCHAR(255) NULL,
	waterfee VARCHAR(255) NULL,
	electricityfee VARCHAR(255) NULL,
	deposit VARCHAR(255) NULL,
	payment VARCHAR(255) NULL,
	renttime VARCHAR(255) NULL,
	decorationtime VARCHAR(255) NULL,
    brokeragetee DECIMAL(13, 2) NULL,
    type VARCHAR(255) NULL,
    note VARCHAR(255) NULL,
    linkofbuilding VARCHAR(255) NULL,
    map VARCHAR(255) NULL,
    avatar VARCHAR(255) NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    managername VARCHAR(255) NULL,
    managerphone VARCHAR(255) NULL
);

-- building 1 - n rentarea
CREATE TABLE rentarea(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    value int NULL,
    buildingid bigint NOT NULL,
	createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

ALTER TABLE rentarea ADD CONSTRAINT rentarea_building FOREIGN KEY (buildingid) REFERENCES building(id);

-- user n - n building
CREATE TABLE assignmentbuilding(
    id bigint NOT NULL PRIMARY KEY auto_increment,
    staffid bigint NOT NULL,
    buildingid bigint NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

ALTER TABLE assignmentbuilding ADD CONSTRAINT fk_user_building FOREIGN KEY (staffid) REFERENCES user(id);
ALTER TABLE assignmentbuilding ADD CONSTRAINT fk_building_user FOREIGN KEY (buildingid) REFERENCES building(id);

CREATE TABLE transaction(
	id bigint NOT NULL PRIMARY KEY auto_increment,
	code VARCHAR(255) NULL,
	note VARCHAR(255) NULL,
	customerid bigint NOT NULL,
	createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

-- customer 1 - n transaction
ALTER TABLE transaction ADD CONSTRAINT fk_customer_transaction FOREIGN KEY (customerid) REFERENCES customer(id);