const { GraphQLServer } = require('graphql-yoga');

function todoById(parent, args, context, info){
    return todosList.find(t => t.id == args.id);
    }
function userById(parent, args, context, info){
    return usersList.find(u => u.id == args.id);
    }
const axios = require("axios")

async function getRestUsersList(){
    try {
        const users = await axios.get("https://jsonplaceholder.typicode.com/users")
        // console.log(users);
        return users.data.map(({ id, name, email, username }) => ({
            id: id,
            name: name,
            email: email,
            login: username,
        }))
    } catch (error) {
        throw error
    }
}

async function getRestTodosList(){
    try {
        const todoslist = await axios.get("https://jsonplaceholder.typicode.com/todos")
        console.log(todoslist);
        return todoslist.data.map(({ userId, id, title, completed }) => ({
            user_id: userId,
            id: id,
            title: title,
            completed: completed,
        }))
    } catch (error) {
        throw error
    }
}

async function userRestById(id){
    users = await getRestUsersList()
    return users.find(u => u.id == id)
}

const usersList = [
    { id: 1, name: "Jan Konieczny", email: "jan.konieczny@wonet.pl", login: "jkonieczny" },
    { id: 2, name: "Anna Wesołowska", email: "anna.w@sad.gov.pl", login: "anna.wesolowska" },
    { id: 3, name: "Piotr Waleczny", email: "piotr.waleczny@gp.pl", login: "p.waleczny" }
    ];
const todosList = [
    { id: 1, title: "Naprawić samochód", completed: false, user_id: 3 },
    { id: 2, title: "Posprzątać garaż", completed: true, user_id: 3 },
    { id: 3, title: "Napisać e-mail", completed: false, user_id: 3 },
    { id: 4, title: "Odebrać buty", completed: false, user_id: 2 },
    { id: 5, title: "Wysłać paczkę", completed: true, user_id: 2 },
    { id: 6, title: "Zamówic kuriera", completed: false, user_id: 3 },
    ];

const resolvers = {
    Query: {
        users: async () => getRestUsersList(),
        todos: () => todosList,
        todo: (parent, args, context, info) => todoById(parent, args, context, info),
        user: (parent, args, context, info) => userById(parent, args, context, info),
        userrest: (parent, args, context, info) => userRestById(args.id),
        },
    User:{
        todos: async (parent, args, context, info) => {
            var todos = await getRestTodosList();
            return todos.filter(t => t.user_id == parent.id);
        }
    },
    ToDoItem:{
        user: (parent, args, context, info) => {
        return usersList.find(u => u.id == parent.user_id);
        }
    },
}
const server = new GraphQLServer({
typeDefs: './src/schema.graphql',
resolvers,
});
server.start(() => console.log(`Server is running on http://localhost:4000`));