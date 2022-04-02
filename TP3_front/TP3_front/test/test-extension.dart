import 'package:flutter/cupertino.dart';
import 'package:flutter_test/flutter_test.dart';

import 'test.widget.dart';

extension TestExtension on Widget {
  Future<Widget> deployWidget(WidgetTester tester, {bool pumpAndSettle = true, Duration duration = const Duration(milliseconds: 100)}) async {
    await tester.pumpWidget(Test(child: this), duration);
    if (pumpAndSettle) await tester.pumpAndSettle(duration);
    return this;
  }
}
