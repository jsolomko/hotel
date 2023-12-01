package com.example.hotelapplication.app.model.booking

class Tourist(
    val name: String
)

class TouristRepository() {
    private val _tourists: MutableList<Tourist> = mutableListOf<Tourist>().apply {
        add(Tourist("Второй турист"))
        add(Tourist("Третий турист"))
        add(Tourist("Четвертый турист"))
    }

    val tourists: List<Tourist>
        get() = _tourists.toList()

    fun getTouristName(index: Int): String {
        return _tourists.getOrNull(index)?.name ?: ""
    }
}