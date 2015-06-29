drop procedure if exists map_prod;
DELIMITER //
CREATE PROCEDURE map_prod(IN distance double(20,10),IN eastLatitude double(20,10),IN northLatitude double(20,10))
	BEGIN   
	  DECLARE PI DECIMAL(50,20) default 3.14159265358979323846;
	  select t.east_latitude el1,t.north_latitude nl1,t.user_id userId from t_hiifit_user_fire t ;
    

		SELECT PI,distance,eastLatitude,northLatitude;

	END;   
	//  
DELIMITER ; 


call map_prod(120.020712,30.284737,120.12336548);
