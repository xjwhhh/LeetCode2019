public class IntersectionOfTwoLinkedLists {
    // 错的
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }
        ListNode pA=headA;
        ListNode pB=headB;
        while(pA!=null&&pB!=null){
            pA=pA.next;
            pB=pB.next;
            if(pA==pB){
                return pA;
            }
        }
        if(pA==pB){
            return pA;
        }
        if(pA==null&&pB!=null){
            pA=headB;
            pB=pB.next;
            while(pA!=null&&pB!=null){
                pA=pA.next;
                pB=pB.next;
                if(pA==pB){
                    return pA;
                }
            }
            if(pA==pB){
                return pA;
            }
            pB=headA;
            pA=pA.next;
            while(pA!=null&&pB!=null){
                pA=pA.next;
                pB=pB.next;
                if(pA==pB){
                    return pA;
                }
            }
            if(pA==pB){
                return pA;
            }
        }else if(pB==null&&pA!=null){
            pB=headA;
            pA=pA.next;
            while(pA!=null&&pB!=null){
                pA=pA.next;
                pB=pB.next;
                if(pA==pB){
                    return pA;
                }
            }
            if(pA==pB){
                return pA;
            }
            pA=headB;
            pB=pB.next;
            while(pA!=null&&pB!=null){
                pA=pA.next;
                pB=pB.next;
                if(pA==pB){
                    return pA;
                }
            }
            if(pA==pB){
                return pA;
            }

        }else{
            pA=headB;
            pB=headA;
            while(pA!=null&&pB!=null){
                pA=pA.next;
                pB=pB.next;
                if(pA==pB){
                    return pA;
                }
            }
            if(pA==pB){
                return pA;
            }


        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }
}
