package net.poundex.fling.demo

import grails.rest.Resource

@Resource
class TodoItem
{
    String itemText
    boolean complete = false
    Category category

    static constraints = {
    }
}
