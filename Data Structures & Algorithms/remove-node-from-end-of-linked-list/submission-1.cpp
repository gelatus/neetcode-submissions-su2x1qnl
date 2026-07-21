/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode dummy(-1, head);
        ListNode *slow = &dummy;
        ListNode *fast = &dummy;

        // Move fast forward n+1 times (+1 because we start at dummy)
        for (int i=0; i<=n; ++i) {
            fast = fast->next;
        }

        // Then move both until fast reaches the last node.
        while (fast) {
            slow = slow->next;
            fast = fast->next;
        }

        // Remove node after slow
        slow->next = slow->next->next;

        return dummy.next;
    }
};
