require_relative "password"
require "test/unit"

class TestPasswordValidator < Test::Unit::TestCase

  def test_empty_input
    assert_equal(false, validate_password(''))
  end

  def test_valid_password
    assert_equal(true, validate_password('7It^^n&2h5@mWTUtefj2'))
  end

  def test_hunter23
    assert_equal(false, validate_password('Hunter23'))
  end

  def test_short_password
    assert_equal(false, validate_password('zku8$df'))
  end

  def test_untypable
    assert_equal(false, validate_password('98yk😍j`sdmD'))
  end

  def test_sequence_letters
    assert_equal(false, validate_password('&Rtijk=%X'))
  end

  def test_sequence_numbers
    assert_equal(false, validate_password('ow456tiQcy5n'))
  end

  def test_only_lower_case
    assert_equal(false, validate_password('aienervew'))
  end

  def test_two_out_of_four
    assert_equal(false, validate_password('thm5igprt'))
  end

=begin
  def test_reversed_dictionary_word
    assert_equal(false, validate_password('32retnuH'))
  end

  def test_obfuscated_dictionary_word
    assert_equal(false, validate_password('P4ssw0rd'))
  end

  def test_xkcd_936
    assert_equal(false, validate_password('blueaeroplanecandywashing'))
  end
=end

end