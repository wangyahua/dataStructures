package com.learn.hash;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-30 13:35
 */
public class HashTab {


    private EmpLinkedList[] empLinkedListArr;


    private int size;


    public HashTab(int size) {
        this.size = size;
        empLinkedListArr = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }


    /**
     * 添加信息
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的id，得到该员工应当添加到哪条链表中
        int hash = hashFun(emp.getId());
        // 将emp添加大对应的散列表中链表中
        empLinkedListArr[hash].add(emp);
    }


    public void findEmpById(int id) {
        // 使用散列函数确定到哪条链表中查找
        int hash = hashFun(id);

        // 根据hash找到对应的数组中，在进行查找，这样就节省了其他数组中的数据
        Emp emp = empLinkedListArr[hash].findEmpById(id);
        if (emp != null) { // 找到
            System.out.printf("在第%d条链表中找到，用户信息：ID:%d,name:%s", hash, emp.getId(), emp.getName());
        } else {
            System.out.println("在哈希表中，没有找到该用户信息");
        }
    }


    /**
     * 遍历散列表中的数据，遍历每个散列表中的链表的数据
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list(i + 1);
        }
    }


    /**
     * 根据用户编号获取需要放到哪个散列表中，散列函数
     *
     * @param id
     * @return
     */
    private int hashFun(int id) {
        return id % this.size;
    }

}
