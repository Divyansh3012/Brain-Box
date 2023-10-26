package com.example.register;

public class QuestionAnswer {

    public static String question[] = {
            // Java Questions
            "What is the purpose of the 'static' keyword in Java?",
            "What is an interface in Java?",
            "What is the difference between 'equals()' and '==' in Java?",
            "What is the 'try-with-resources' statement used for in Java?",
            "What is a constructor in Java?",
            "What is method overloading in Java?",
            "What is method overriding in Java?",

            // Web Development Questions
            "What is the purpose of JavaScript in web development?",
            "What is the role of a web server in serving web pages?",
            "What is a responsive web design?",
            "What does AJAX stand for in web development?",
            "What is the role of CSS in web development?",

            // Other Programming Languages Questions
            "What is the 'for' loop in C++ used for?",
            "What is the primary use of the 'break' statement in C#",
            "What is Python known for?",
    };

    public static String choices[][] = {
            // Java Questions
            {"To define a class method", "To create an instance of a class", "To declare a constant", "To allocate memory for an object"},
            {"A class with only abstract methods", "A class that cannot be instantiated", "A class used for multiple inheritance", "A class with no methods"},
            {"'equals()' compares object values, '==' compares references", "'equals()' is used for primitive types, '==' is used for objects", "They are equivalent and can be used interchangeably", "'equals()' is a keyword, '==' is a method"},
            {"To handle exceptions and resources automatically", "To execute a block of code repeatedly", "To group multiple classes together", "To define a static method"},
            {"A method used for object destruction", "A method that returns a boolean value", "A method used to create objects", "A method used for mathematical calculations"},
            {"Creating multiple methods with the same name but different parameters", "Overriding a method in a subclass", "Creating multiple methods with the same name and return type", "Creating static methods in a class"},
            {"Method overloading allows defining multiple methods with the same name but different parameters.", "Method overriding is when a subclass provides a specific implementation for a method defined in its superclass.", "Method overriding and method overloading are the same concepts.", "Method overriding is not supported in Java."},

            // Web Development Questions
            {"To add interactivity and behavior to web pages", "To define the structure of a web page", "To store data on the client's computer", "To format the layout and design of a web page"},
            {"To serve web pages to clients", "To store web page content", "To block access to websites", "To create web page layouts"},
            {"Designing websites that adapt to different screen sizes and devices", "Designing websites with colorful backgrounds", "Designing websites with complex animations", "Designing websites with large images"},
            {"Asynchronous JavaScript and XML", "Advanced JavaScript and XML", "Ajax is not related to web development", "Automated JavaScript and XML"},
            {"CSS stands for 'Computer Style Sheet' and is not used in web development.",
                    "CSS is used for defining the structure and content of a web page.",
                    "CSS is primarily used for server-side scripting in web development.",
                    "CSS is responsible for adding interactivity to web pages."},

            // Other Programming Languages Questions
            {"To create an infinite loop", "To iterate through a range of values", "To execute a block of code repeatedly", "To exit a loop prematurely"},
            {"To skip the current iteration of a loop", "To execute a block of code repeatedly", "To define a new function", "To create a class"},
            {"Python is known for its high-speed performance.",
                    "Python is known for being a compiled language.",
                    "Python is known for its readability and simplicity.",
                    "Python is known for its complex syntax."},
    };

    public static String correctAnswers[] = {
            // Java Questions
            "To define a class method",
            "A class with only abstract methods",
            "'equals()' compares object values, '==' compares references",
            "To handle exceptions and resources automatically",
            "A method used to create objects",
            "Creating multiple methods with the same name but different parameters",
            "Method overriding is when a subclass provides a specific implementation for a method defined in its superclass.",

            // Web Development Questions
            "To add interactivity and behavior to web pages",
            "To serve web pages to clients",
            "Designing websites that adapt to different screen sizes and devices",
            "Asynchronous JavaScript and XML",
            "CSS is used for defining the structure and content of a web page.",

            // Other Programming Languages Questions
            "To iterate through a range of values",
            "To skip the current iteration of a loop",
            "Python is known for its readability and simplicity."
    };
}
