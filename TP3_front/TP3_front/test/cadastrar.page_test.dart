import 'package:crud/cadastrar.page.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';

import 'test-extension.dart';
import 'test.widget.dart';

main() {
  getWidget() {
    return CadastrarPage();
  }
  testWidgets('colocar os textos nos campos e apertar o botão', (tester) async {
    await getWidget().deployWidget(tester);
    await tester.enterText(find.byKey(Key("nomeField")), '11111111');
    await tester.enterText(find.byKey(Key("idadeField")), '11111111');
    await tester.enterText(find.byKey(Key("telefoneField")), 'honda');
    await tester.tap(find.byKey(Key("telefoneField")));
    await tester.pumpAndSettle();
  });
}
