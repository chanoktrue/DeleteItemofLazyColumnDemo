package com.mynpe.deleteitemoflazycolumndemo

data class BasicItems(
    val name: String,
    val count: Int
)

fun getListItems() = listOf(
    BasicItems("Books", 3),
    BasicItems("Mobiles", 2),
    BasicItems("Views", 7),
    BasicItems("Subscribers", 9),
    BasicItems("Comments", 4),
    BasicItems("Likes", 6),
    BasicItems("Books", 3),
    BasicItems("Mobiles", 2),
    BasicItems("Views", 7),
    BasicItems("Subscribers", 9),
    BasicItems("Comments", 4),
    BasicItems("Likes", 6)
)
