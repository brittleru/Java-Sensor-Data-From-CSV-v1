# Java program for parsing data from CSV and creating new CSVs version 1.0 
This is a project I had in university in the third year at the Java and Python Programming course. This course was taught by Conf. Dr. Ing. Victor Constantin. 
</br>
I had to find a way to parse a comma separated values (CSV) file which had some data from sensors, the CSV had three different columns for temperatures, three different columns for humidity, one for velocity, two columns for presence (it was a Boolean value), one row for time for that particular value and one for current number. 
</br>
The task was to create a different CSV for each type of values form the sensors (e.g., one CSV for all three columns of temperatures). Every CSV needed to have a column (beside the values) for the date when the readings were done and also a column for the current number. 
</br>
There were some restrictions for each new CSV:
<ul>
  <li><b>Temperature:</b> there I had to overwrite the value to be between -5 and 5 and set it to -5 if it was lower than -5 and 5 if it was higher than 5.</li>
  <li><b>Humidity:</b> there I had to overwrite the values form the sensor to be 40 if they are lower than 40</li>
  <li><b>Velocity:</b> there I had to increment the value from the sensor with 1</li>
</ul>
<h2> My solution </h2>
To solve that problem I created two classes, one for reading the original CSV and one to parse and create the new CSVs, which had a function for each type of value. To write in CSV I used a foreach loop and I .split() method the line by “,” and I stored the value of the line to an array which I used to write the values for the CSV
