import 'dart:convert';
import 'package:http/http.dart' as http;

import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'model/motocicleta.model.dart';

class CadastrarPage extends StatefulWidget {
  const CadastrarPage({Key? key}) : super(key: key);

  @override
  State<CadastrarPage> createState() => _CadastrarPageState();
}

class _CadastrarPageState extends State<CadastrarPage> {
  var modeloController = TextEditingController();
  var precoController = TextEditingController();
  var marcaController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(24.0),
        child: Column(
          children: [
            TextField(
              key: Key('nomeField'),
              controller: modeloController,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                hintText: 'nome',
              ),
            ),
            SizedBox(
              height: 16,
            ),
            TextField(
              key: Key('idadeField'),
              controller: precoController,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                hintText: 'idade',
              ),
            ),
            SizedBox(
              height: 16,
            ),
            TextField(
              key: Key('telefoneField'),
              controller: marcaController,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                hintText: 'telefone',
              ),
            ),
            SizedBox(
              height: 24,
            ),
            ElevatedButton(
              key: Key('botao'),
              child: Text('Cadastrar'),
              onPressed: () {
                Motocicleta motocicleta = Motocicleta(
                  id: DateTime.now().microsecondsSinceEpoch.toString(),
                  modelo: modeloController.text,
                  preco: double.parse(precoController.text),
                  marca: marcaController.text,
                );
                saveUser(motocicleta: motocicleta);
              },
              style: ElevatedButton.styleFrom(
                  primary: Colors.green,
                  padding: EdgeInsets.symmetric(horizontal: 50, vertical: 20),
                  textStyle:
                      TextStyle(fontSize: 30, fontWeight: FontWeight.bold)),
            ),
          ],
        ),
      ),
    );
  }

  void saveUser({required Motocicleta motocicleta}) async {
    var url = Uri.parse('http://192.168.0.48:8080/cadastro');
    var formatedUser = motocicleta.toJson();
    print(json.encode(formatedUser));
    try {
      // await Dio().post('localhost:8080/cadastro',
      //     data: json.encode(formatedUser),
      //     options: Options(headers: {
      //       "Accept": "application/json",
      //       "Access-Control_Allow_Origin": "*"
      // }));
      await http.post(
        url,
        body: json.encode(formatedUser),
        headers: {"Content-Type": "application/json"},
      );
      // print(await http.read(Uri.parse('https://example.com/foobar.txt%27)));
    } catch (e) {
      print(e.toString());
    }
  }
}
