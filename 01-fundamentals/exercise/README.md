# Exercise: "Student Grades Analyzer"

Objective: Write a Java program that analyzes and calculates some basic statistics from a list of student grades.

## Requirements:
1.	Prompt for Input: Ask the user to input grades for a group of students.
  - Use an `ArrayList` for storing the grades.
  - Use a loop to collect grades, ensuring that the grades are between 0 and 100 (use a conditional statement to validate the input).
2.	Type Casting & Primitives:
  - If grades are input as doubles (e.g., 85.5, 90.2), cast them to integers when necessary, before storing them in the `ArrayList<Integer>`.
3.	Calculations:
  - Find the highest grade using a loop.
  - Find the lowest grade using a loop.
  - Calculate the average grade.
  - Determine the number of passing grades (a grade >= 60 is considered passing).
4.	Conditional Statements:
  - Output whether the class passed overall. The class is considered to have passed if the average grade is >= 60.
5.	Switch Statements:
  - After the calculations are complete, use a switch statement to categorize the class's performance:
  - If the average is between 90-100: "Excellent"
  - If the average is between 80-89: "Good"
  - If the average is between 70-79: "Average"
  - If the average is between 60-69: "Passable"
  - Otherwise: "Failing"
6.	Ternary Operator:
  - Use a ternary operator to determine whether to print "Great job!" or "Keep trying!" based on whether the highest grade is >= 90.