import os


def delete_class_files(directory):
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith('.class'):
                file_path = os.remove(os.path.join(root, file))
                print(f"Deleted {file_path}")


if __name__ == '__main__':
    # Get the current working directory and delete all .class filese
    directory = os.getcwd()
    delete_class_files(directory)
