# Shortest_Route_Brute_Force_Travelling_Salesman

This Java program reads a file "input.txt" which contains coordinates of multiple homes and a Migros store. It then calculates the distances between all homes and the Migros store using the distance formula. The program uses a recursive method to generate all possible routes starting from the Migros store to visit all homes and return back to the store. The method then compares the total distance of each route with the previous minimum distance stored in an ArrayList and updates it if the current distance is less than the previous minimum. The final output displays the shortest route and the distance of that route.

To use this program, you need to create an "input.txt" file with the coordinates of homes and the Migros store separated by a comma in each line. The program also requires Java installed on the computer to run.

To run this program, write java -jar shortest_route.jar in command line.

Node size cant be more than 12 due to time complexity. 

![image](https://user-images.githubusercontent.com/57816597/219977881-f973970c-ef7b-48e4-a08a-88b452bfc7b0.png)
