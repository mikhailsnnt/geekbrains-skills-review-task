package geekbrains.sainnt.builder

class Person private constructor(
    var firstName: String? = null,
    var lastName: String? = null,
    var middleName: String? = null,
    var country: String? = null,
    var address: String? = null,
    var phone: String? = null,
    var age: Int? = null,
    var gender: String? = null
) {
    class Builder() {
        private val result = Person()

        fun build() = result

        fun firstName(firstName: String): Builder = apply {
            result.firstName = firstName
        }

        fun lastName(lastName: String): Builder = apply {
            result.lastName = lastName
        }

        fun middleName(middleName: String): Builder = apply {
            result.middleName = middleName
        }

        fun country(country: String): Builder = apply {
            result.country = country
        }

        fun address(address: String): Builder = apply {
            result.address = address
        }

        fun phone(phone: String): Builder = apply {
            result.phone = phone
        }

        fun age(age: Int): Builder = apply {
            result.age = age
        }

        fun gender(gender: String): Builder = apply {
            result.gender = gender
        }
    }
}