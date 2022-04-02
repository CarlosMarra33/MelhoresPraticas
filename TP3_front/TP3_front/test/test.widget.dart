import 'package:flutter/material.dart';

class Test extends StatelessWidget {
  final Widget child;

  const Test({
    Key? key,
    required this.child,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Test',
      home: Scaffold(
        body: child,
      ),
    );
  }
}