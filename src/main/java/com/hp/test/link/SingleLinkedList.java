package com.hp.test.link;

public class SingleLinkedList {

    private int size;

    private Node head;

    /**
     * 给链表头插入元素
     *
     * @param val
     */
    public void addFirst(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
        size++;
    }

    public Node getTail() {
        Node curor = head;
        while (curor.next != null) {
            curor = curor.next;
        }
        return curor;
    }

    public void addTail(int val) {
        Node tail = getTail();
        Node newTail = new Node(val);
        tail.next = newTail;
        size++;
    }

    public void addTail2(int val) {
        Node curor = head;
        while (curor.next != null) {
            curor = curor.next;
        }
        curor.next = new Node(val);
        size++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * 遍历链表
     *
     * @return
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cursor = head;
        while (cursor != null) {
            sb.append(cursor.val).append("-->");
            cursor = cursor.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public void addIndex(int index, int val) {
        Node temp = new Node(val);
        if (index < 0 || index > size - 1) {
            System.out.println("error");
            return;
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        Node preNode = head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        temp.next = preNode.next;
        preNode.next = temp;
        size++;
    }

    public Node get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Node curso = head;
        int i = 0;
        while (curso != null) {
            if (index == i) {
                break;
            } else {
                i++;
                curso = curso.next;
            }
        }
        return curso;
    }

    public boolean contains(int value) {
        Node curso = head;
        while (curso != null) {
            if (curso.val == value) {
                return true;
            } else {
                curso = curso.next;
            }
        }
        return false;
    }

    public void set(int index, int newvalue) {
        if (checkRange(index)) {
            Node node = get(index);
            node.val = newvalue;
        } else {
            System.out.println("out of index");
        }
    }

    private boolean checkRange(int index) {
        if (index < 0 || index >= size) {
            return false;
        } else {
            return true;
        }
    }

    public Node removeIndex(int index) {
        if (checkRange(index)) {
            if (index == 0) {
                Node temp = head;
                head = head.next;
                size--;
                temp.next = null;
                return temp;
            }
            // 目标，找到索引的前一个节点
            Node virualNode = new Node(-1);
            virualNode.next = head;
            for (int i = 0; i <= index - 1; i++) {
                virualNode = virualNode.next;
            }
            Node deleteNode = virualNode.next;
            virualNode.next = virualNode.next.next;
            size--;
            deleteNode.next = null;
            return deleteNode;
        } else {
            System.out.println("out of range");
            return null;
        }
    }

    public Node removeFirst() {
        return removeIndex(0);
    }

    public Node removeLast() {
        return removeIndex(size - 1);
    }

    /**
     * 有bug
     *
     * @param val
     */
    public void removeValueOnce2(int val) {
        //遍历链表，找到值为val的节点->不知道值为val的节点在哪个位置
        //找到后删除（正常的删除都需要找到前驱，只有头节点没有前驱）
        if (head != null && head.val == val) {
            //头节点就是待删除节点
            Node temp = head;
            head = head.next;
            temp.next = null;
            size--;
        } else {
            //此时head一定不是待删除节点
            Node prev = head;
            //prev指向待删除的前驱，要判断前驱的下一个节点值是否等于val
            while (prev.next != null) {
                //cur 就是待删除的节点
                if (prev.next.val == val) {
                    Node cur = prev.next;
                    cur.next = null;
                    size--;
                    return;
                }
                //如果不走if分支，说明prev不是待删除节点的前驱，让prev向后移动
                prev = prev.next;
            }
        }
    }

    public Node removeValueOnce(int value) {
        if (head.val == value) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            size--;
            return temp;
        } else {
            Node pre = head;
            boolean flag = false;
            while (pre.next != null) {
                if (pre.next.val == value) {
                    flag = true;
                    break;
                }
                pre = pre.next;
            }
            if (flag) {
                Node delete = pre.next;
                pre.next = pre.next.next;
                delete.next = null;
                size--;
                return delete;
            } else {
                return null;
            }
        }
    }

    public void removeValueAll(int value) {
        Node virualNode = new Node(-1);
        virualNode.next = head;
        Node preCursor = virualNode;
        Node cursor = virualNode.next;
        while (cursor != null) {
            if (cursor.val == value) {
                Node delete = cursor;
                preCursor.next = delete.next;
                cursor = cursor.next;
                delete.next = null;
                size--;
            } else {
                preCursor = cursor;
                cursor = cursor.next;
            }
        }
        head = virualNode.next;
    }


    public void removeValueAll2(int val) {
        //判断头节点是否为待删除节点
        while (head != null && head.val == val) {
            head = head.next;
            size--;
        }
        if (head == null) {
            //此时链表中全是val且已经被删空
            return;
        } else {
            //此时head一定不是待删除节点，且链表中还有节点
            Node prev = head;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    //此时prev.next就是待删除节点
                    Node cur = prev.next;
                    prev.next = cur.next;
                    cur.next = null;
                    size--;
                } else {
                    //只有当确保prev.next不是待删除的节点时才能移动prev指向
                    //保证prev一定不是待删除节点，如果prev是待删除节点，那该节点一定删不掉
                    prev = prev.next;
                }
            }
        }
    }


}

class Node {
    // 存储具体数据
    int val;
    // 保存下一个车厢的地址
    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        if (this.next == null) {
            return String.join("", String.valueOf(this.val));
        } else {
            return String.valueOf(this.val) + "--->" + this.next.toString();
        }
    }

}
