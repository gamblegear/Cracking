/*
Max Points on a Line
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
Analysis:
First of all, how to know the points are on the same line?  The slope!
The slope of a line can be computed using any two points (x1,y1) (x2,y2) on the line:
 slop = (y2-y1)/(x2-x1) , x2!=x1.

In this problem, we want to know the max number of points on one line. We can think in this way:  for one point, we can easily compute all the possible lines (slopes) which goes across this point and  any other point in the plane. Why? Because at least two points can determine a line, we now fix one point, and get all the lines using one other point.  For these lines, the starting point is the same, so if the slope is same, they are actually the same line.

So, we can have a loop from the 1st point to the last point. Within this loop, we fix the current point and compute the find the max number of points, which has the same slope. Once we have this number in one iteration, the max number of all the iterations is what we want.

The algorithm goes like this:
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
for each point i in the plane:
    for each point j in the plane:
          if i!=j,
             Compute and store the slop
    Sort the slop array
    Count how many slops are the same
    Store the max number

Output the max number
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


Note:
(1) The slop is computed using "/", if (x2-x1)==0, there will be an error, but in the 2D plane it is a valid line (vertical line). So, store the vertical line as a specific slope is needed.

(2) Remember to consider the input points have duplicates. In my code, I only consider the duplicates with the starting point in each loop, the slop is not computed then but the number of duplicates are stored instead. Also be careful with all the input points are the same case.
*/