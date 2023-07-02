import subprocess
import shlex

def bruteforce_license():
    stab = list("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")
    for key1 in stab:
        for key2 in stab:
            for key3 in stab:
                for key5 in stab:
                    for key7 in stab:
                        for key8 in stab:
                            sum_123 = ord(key1) + ord(key2) + ord(key3)
                            sum_578 = ord(key5) + ord(key7) + ord(key8)

                            if sum_123 == 203 and sum_578 == 214:
                                key_str = "7" + key1 + key2 + key3 + "-" + key5 + "D" + key7 + key8
                                command = "./license --key=" + shlex.quote(key_str)
                                try:
                                    output = subprocess.check_output(command, shell=True, stderr=subprocess.DEVNULL)
                                    output_str = output.decode().strip()

                                    if "SecVal" in output_str:
                                        print("Key found: " + key_str)
                                        print("Output: " + output_str)
                                        return  # Kết thúc chương trình sau khi tìm thấy khóa
                                except subprocess.CalledProcessError:
                                    continue

bruteforce_license()