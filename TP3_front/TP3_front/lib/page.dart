import 'package:crud/cadastrar.page.dart';
import 'package:crud/controller/User.controller.dart';
import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  const MainPage({Key? key}) : super(key: key);

  @override
  State<MainPage> createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  var nameController = TextEditingController();
  var idadeController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue,
      body: Column(children: [
        // lista.isEmpty
        //     ? ListView.builder(
        //         itemCount: lista.length,
        //         itemBuilder: (context, index) {
        //           return Text(lista[index].toString());
        //         },
        //       )
        //     : Container(),
        // TextField(
        //   controller: nameController,
        //   decoration: const InputDecoration(
        //     border: OutlineInputBorder(),
        //     hintText: 'nome',
        //   ),
        // ),
        // TextField(
        //   controller: idadeController,
        //   decoration: const InputDecoration(
        //     border: OutlineInputBorder(),
        //     hintText: 'idade',
        //   ),
        // ),
        RaisedButton(
          child: Text("criar user"),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => CadastrarPage()),
            );
          },
        )
      ]),
    );
  }
}
