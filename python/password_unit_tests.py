# This exercise uses the encoding: utf-8
import unittest
from password import validate_password

class TestPasswordValidator(unittest.TestCase):

    def test_empty_input(self):
        self.assertIs(validate_password(''), False)

    def test_valid_password(self):
        self.assertIs(validate_password('7It^^n&2h5@mWTUtefj2'), True)

    def test_hunter_23(self):
        self.assertIs(validate_password('Hunter23'), False)

    def test_short_password(self):
        self.assertIs(validate_password('zku8$df'), False)

    def test_untypable(self):
        self.assertIs(validate_password('98yk😍j`sdmD'), False)

    def test_sequence_letters(self):
        self.assertIs(validate_password('&Rtijk=%X'), False)

    def test_sequence_numbers(self):
        self.assertIs(validate_password('ow456tiQcy5n'), False)

    def test_only_lower_case(self):
        self.assertIs(validate_password('aienervew'), False)

    def test_two_out_of_four(self):
        self.assertIs(validate_password('thm5igprt'), False)

#    def test_reversed_dictionary_word(self):
#        self.assertIs(validate_password('32retnuH'), False)

#    def test_obfuscated_dictionary_word(self):
#        self.assertIs(validate_password('P4ssw0rd'), False)

#    def test_xkcd_936(self):
#        self.assertIs(validate_password('blueaeroplanecandywashing'), True)


suite = unittest.TestLoader().loadTestsFromTestCase(TestPasswordValidator)
unittest.TextTestRunner(verbosity=2).run(suite)