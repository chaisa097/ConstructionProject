CREATE TABLE IF NOT EXISTS `RECEIVE_MATERIAL` (
  `RECEIVE_MATERIALID` int(100) NOT NULL AUTO_INCREMENT,
  `EMPLOYEEID` int(100) NOT NULL,
  `ORDER_MATERIALID` int(100) NOT NULL,
  `RECEIVE_MATERIALNO` varchar(6) NOT NULL,
  `RECEIVE_DATE` date NOT NULL,
   PRIMARY KEY (`RECEIVE_MATERIALID`),
    foreign key (EMPLOYEEID) references EMPLOYEE(EMPLOYEEID)    
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0;