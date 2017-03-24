/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizsystem;

import java.util.ArrayList;

/**
 *
 * @author Meeth
 */
public class Questions {

    /**
     * attribute of questions ie question number
     */
    public int qno;

    /**
     * attributes of questions
     */
    public String desc;
    String choice1;
    String choice2;
    String choice3;
    String choice4;
    String ans;
    static int i = 0;
    static int j = 0;
    ReadFiles r = new ReadFiles();

    /**
     * no-args constructor of questions
     */
    public Questions() {
        
    }

    /**
     * get question number
     * @return q
     */
    public int getQno() {
        return qno;
    }

    /**set qnuestion number
     *
     * @param qno
     */
    public void setQno(int qno) {
        this.qno = qno;
    }

    /**
     *description
     * @return question
     */
    public String getDesc() {
        return desc;
    }

    /**
     * set the question
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * get the choice
     * @return choice 1
     */
    public String getChoice1() {
        return choice1;
    }

    /**
     * set the choice
     * @param choice1
     */
    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    /**
     *get the choice
     * @return choice2
     */
    public String getChoice2() {
        return choice2;
    }

    /**
     *set the choice
     * @param choice2
     */
    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    /**
     *get the choice
     * @return
     */
    public String getChoice3() {
        return choice3;
    }

    /**
     *
     * @param choice3
     */
    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    /**
     *get the choice
     * @return choice4
     */
    public String getChoice4() {
        return choice4;
    }

    /**
     *
     * @param choice4
     */
    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    /**
      get ans
     * @return ans
     */
    public String getAns() {
        return ans;
    }

    /**
     * set the ans
     * @param ans
     */
    public void setAns(String ans) {
        this.ans = ans;
    }

}
