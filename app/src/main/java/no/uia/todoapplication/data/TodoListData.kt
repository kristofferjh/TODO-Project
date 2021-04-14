package no.uia.todoapplication.data

data class TodoListData(val title: String) {
}

data class TodoListTask(val title: String, var isDone: Boolean = false) {
}