// import '../model/user.model.dart';

// class UserController {
//   List<User> listaUser = [];

//   cadastrar(String name, String idade, String telefone) {
//     var user = User(
//       id: DateTime.now().millisecondsSinceEpoch,
//       name: name,
//       idade: idade,
//       telefone:telefone,
//     );
//     listaUser.add(user);
//   }

//   get listar {
//     return listaUser;
//   }

//   delete(int id) {
//     listaUser.removeWhere((user) => user.id == id);
//   }

//   edit({required int id, String? name, String? idade, String? telefone}) {
//     User? userUPdate;
//     listaUser.forEach((user) => user.id == id ? userUPdate = user : null);
//     listaUser.removeWhere((user) => user.id == id);
//     var newUser = User(
//       id: id,
//       name: name ?? userUPdate!.name,
//       idade: idade ?? userUPdate!.idade,
//       telefone: telefone ?? userUPdate!.telefone,
//     );
//     listaUser.add(newUser);
//   }
// }
