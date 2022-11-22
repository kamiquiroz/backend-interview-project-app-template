INSERT INTO customers VALUES('1','Kami');
INSERT INTO customers VALUES('2','Mile');

INSERT INTO types VALUES('1','MAC');
INSERT INTO types VALUES('2','WINDOWS SERVER');
INSERT INTO types VALUES('3','WINDOWS WORKSTATION');

INSERT INTO devices VALUES('1',4.0,'MAC1',1);
INSERT INTO devices VALUES('2',4.0,'MAC2',1);
INSERT INTO devices VALUES('3',4.0,'WIN1',2);
INSERT INTO devices VALUES('4',4.0,'WIN2',3);
INSERT INTO devices VALUES('5',4.0,'MAC3',1);

INSERT INTO services VALUES('1','Antivirus');
INSERT INTO services VALUES('2','Backup');
INSERT INTO services VALUES('3','Screen Share');

INSERT INTO service_costs VALUES('1',7.0,1,1);
INSERT INTO service_costs VALUES('2',5.0,1,2);
INSERT INTO service_costs VALUES('3',5.0,1,3);

INSERT INTO service_costs VALUES('4',3.0,2,1);
INSERT INTO service_costs VALUES('5',3.0,2,2);
INSERT INTO service_costs VALUES('6',3.0,2,3);

INSERT INTO service_costs VALUES('7',1.0,3,1);
INSERT INTO service_costs VALUES('8',1.0,3,2);
INSERT INTO service_costs VALUES('9',1.0,3,3);

INSERT INTO service_assignments VALUES('1',CURRENT_DATE(),1,1);
INSERT INTO service_assignments VALUES('2',CURRENT_DATE(),1,2);
INSERT INTO service_assignments VALUES('3',CURRENT_DATE(),1,3);

INSERT INTO service_assignments VALUES('4',CURRENT_DATE(),2,1);
INSERT INTO service_assignments VALUES('5',CURRENT_DATE(),2,2);
INSERT INTO service_assignments VALUES('6',CURRENT_DATE(),2,3);

INSERT INTO service_assignments VALUES('7',CURRENT_DATE(),3,1);
INSERT INTO service_assignments VALUES('8',CURRENT_DATE(),3,2);
INSERT INTO service_assignments VALUES('9',CURRENT_DATE(),3,3);

INSERT INTO service_assignments VALUES('10',CURRENT_DATE(),4,1);
INSERT INTO service_assignments VALUES('11',CURRENT_DATE(),4,2);
INSERT INTO service_assignments VALUES('12',CURRENT_DATE(),4,3);

INSERT INTO service_assignments VALUES('13',CURRENT_DATE(),5,1);
INSERT INTO service_assignments VALUES('14',CURRENT_DATE(),5,2);
INSERT INTO service_assignments VALUES('15',CURRENT_DATE(),5,3);

INSERT INTO device_assignments VALUES('1',1,1);
INSERT INTO device_assignments VALUES('2',1,2);
INSERT INTO device_assignments VALUES('3',1,3);
INSERT INTO device_assignments VALUES('4',1,4);
INSERT INTO device_assignments VALUES('5',1,5);


