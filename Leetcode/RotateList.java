/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/*
Use 3 pointers to point to the specific place.

Also think about how to rotate for arrays.
 */

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
            if (head == null)
                    return head;
            int length = 1;
            ListNode last = head;
            while (last.next != null) {
                    last = last.next;
                    length++;
            }
            n = n % length;
            if (n == 0)
                    return head;
            int steps = length - n;
            ListNode start = new ListNode(0);
            start.next = head;
            while (steps > 0) {
                    start = start.next;
                    steps--;
            }
            ListNode ret = start.next;
            start.next = null;
            last.next = head;
            return ret;
    }
}

// This is the way to rotate an arrays
void leftRotate(int arr[], int d, int n)
{
  int i, j, k, temp;
  for (i = 0; i < gcd(d, n); i++)
  {
    /* move i-th values of blocks */
    temp = arr[i];
    j = i;
    while(1)
    {
      k = j + d;
      if (k >= n)
        k = k - n;
      if (k == i)
        break;
      arr[j] = arr[k];
      j = k;
    }
    arr[j] = temp;
  }
}

int gcd(int a,int b)
{
   if(b==0)
     return a;
   else
     return gcd(b, a%b);
}