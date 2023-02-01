package Test;
import java.util.Scanner;
/* Class BTNode */
class BTNode
{
    BTNode left, right;
    int data;
    String workout;
    /* Constructor */
    public BTNode()
    {
        left = null;
        right = null;
        data = 0;
        workout= "None yet";
    }
    /* Constructor */
    public BTNode(int n, String workout)
    {
        left = null;
        right = null;
        data = n;
        this.workout = workout;
    }
    /* Function to set left node */
    public void setLeft(BTNode n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BTNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public BTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BTNode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }
    /* Function to get data from node */
    public int getData()
    {
        return data;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }
}

