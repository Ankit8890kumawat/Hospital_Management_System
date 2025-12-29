INSERT INTO patient (name, gender, birth_date, email,blood_group)
VALUES
    ('Ankit kumawat','male','1990-05-10','aarav.sharma@exaple.com','A_POSITIVE'),
    ('Aaman kumar','male','1996-09-11','aman.kumar@gmail.com','A_NEGATIVE'),
    ('KHUSHBU YADAV','Female','1988-11-30','khushbu@gmail.com','O_POSITIVE'),
    ('priti','female','1999-12-21','pritikumar@gmail.com','AB_POSITIVE'),
    ('vikesh','male','1987-12-12','vikeshkumar@gmail.com','AB_POSITIVE');

INSERT INTO doctor(name,specialization,email)
VALUES
    ('Dr.Rakesh Mehta','Cardiology','rakesh.mehta@example.com'),
    ('Dr.sneha kapoor','Dermatology','sneha.kapoor@example.com'),
    ('Dr.Arjun nair','Orthopedice','arjun.nair@example.com');


INSERT INTO appointment(appointment_time, reason,doctor_id,patient_id)
VALUES
    ('2025-07-02 10:30:00','General Checkup ',1,2),
    ('2025-07-02 11:00:00','Skin Rash',2,2),
    ('2025-07-03 09:45:00','knee Pain',3,3),
    ('2025-07-05 14:00:00','follow-up visit',1,1),
    ('2025-07-05 16:15:00','Consultation',1,4),
    ('2025-07-06 08:30:00','Allergy Treatment',2,5);



