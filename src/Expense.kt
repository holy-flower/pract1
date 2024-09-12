class Expense(var sumExpenses: Int, var category: String, var date: String) {

    fun displayList() {
        println("Сумма расхода: $sumExpenses, категория: $category, дата: $date")
    }
}

class ExpenseTracker {
    private val expensesList = mutableListOf<Expense>()

    fun addExpense(expenses: Expense) {
        expensesList.add(expenses)
    }

    // ----
    fun categoryList(category: String) {
        println("Расходы в категории $category")
       // expensesList.
        expensesList.filter { it.category == category }.forEach { it.displayList() }
    }

    fun sunInCategory(category: String): Map<Boolean, Int> {
        return expensesList.groupBy { it.category == category }.mapValues { (_, expenses) -> expenses.sumOf { it.sumExpenses } }
    }

    fun allExpenses() {
        expensesList.forEach { it.displayList() }
    }
}

fun main() {
    val expenses = ExpenseTracker()

    expenses.addExpense(Expense(100, "Продукты", "06/09/2024"))
    expenses.addExpense(Expense(50, "Транспорт", "12/05/2024"))
    expenses.addExpense(Expense(200, "Развлечения", "16/07/2024"))
    expenses.addExpense(Expense(75, "Продукты", "26/08/2024"))

    println("Все расходы:")
    expenses.allExpenses()

    println("\nРасходы по категории продукты")
    expenses.categoryList("Продукты")

    println("\nСумма расходов по категории продукты")
    expenses.sunInCategory("Продукты")



}