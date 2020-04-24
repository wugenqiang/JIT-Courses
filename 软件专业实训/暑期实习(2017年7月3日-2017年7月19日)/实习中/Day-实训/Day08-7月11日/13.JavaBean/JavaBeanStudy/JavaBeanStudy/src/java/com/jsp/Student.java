/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jsp;

/**
 *
 * @author ibm
 */
public class Student {
    private long classno;
    private String  name;
    private int age;
    private boolean sex;
    private String major;

    /**
     * @return the classno
     */
    public long getClassno() {
        return classno;
    }

    /**
     * @param classno the classno to set
     */
    public void setClassno(long classno) {
        this.classno = classno;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the sex
     */
    public boolean isSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

}
