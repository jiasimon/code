package com.sjia.Leetcode;

public class CombineTwoTables {

    // #175. Combine Two Tables https://leetcode.com/problems/combine-two-tables/
    // Write a SQL query for a report that provides the  information for each person in the Person table,
    // regardless if there is an address for each of those people:
    /*
    Table: Person

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | personId    | int     |
    | lastName    | varchar |
    | firstName   | varchar |
    +-------------+---------+

    Table: Address

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | addressId   | int     |
    | personId    | int     |
    | city        | varchar |
    | state       | varchar |
     */

/*
    select FirstName, LastName, City, State
    from Person p left join Address a
    on p.PersonId = a.PersonId
    */


}
