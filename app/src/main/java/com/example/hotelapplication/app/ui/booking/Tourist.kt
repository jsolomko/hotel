package com.example.hotelapplication.app.ui.booking

class Tourist(
    val name: String
)

class TouristRepository() {
    val tourists: MutableList<Tourist> = mutableListOf<Tourist>().apply {
        add(Tourist("Второй турист"))
        add(Tourist("Третий турист"))
        add(Tourist("Четвертый турист"))
    }

}