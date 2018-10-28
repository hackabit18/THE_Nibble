								Idea 

The current system of taking attendence in colleges and in schools is a tedious task, isn't it? We come with this Digital Attendence Register(DAR) app with the goal to make life easier for people. This app has two different forms, for the teacher and for the students. This app creates an interface for the teacher as well as students to easily go through the attendence process. The app uses a face detection and recognition system to get the details of students to mark their attendence. The basic idea behind making this app is to save the whole class's time as well as to stop proxies to some extent at zero expense.

						    		Tools and Technologies used

Android studio, Firebase to handle database, OpenCV and Local Binary Pattern Histogram for face detection. Netwoking part is implemented by Java Networking calsses.					

								App Implementation

This app has two different forms, one for the teacher and one for the students. The teacher app opens with a login and registration page. Each subject teacher registers himself/herself on the app so that they can login. The teacher creates a local server on his/her phone and the students connect through their apps via the ip address of teacher's phone and a port number. 
The students register themselves on the database through their apps. The registration process for students include Face Detection process in which their faces is scanned from different angles to have better results in future. The students login and as soon as they connect with the local server created by teacher, the app performs a face recognition process. A successful recognition implies that the student is a valid user and the app is redirected to a new window where the student can mark their attendence by himself/herself. Currently 8-10 students are connected at one time from the server.

						   		Application and Future Scope

The app can be used in classes to take attendence with minimum efforts. 
The reach of the app can be widened in the future as the accuracy of face detection and recognition system improves which is dependent of the learning phase of the machine and other factors like improvement in phone camera quality. The local server can be made by router so that more people can be connected at the same time. So its use can be further extended to offices. 

								License

This project is licensed under the MIT License.
