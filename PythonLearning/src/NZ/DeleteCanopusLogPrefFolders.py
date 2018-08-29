
import shutil
import os.path

folders = ['D:\\proj\\Branches\\Users\\nzheng\\com2_0\\Canopus\\build\\logFiles',
           'D:\\proj\\Branches\\Users\\nzheng\\com2_0\\Canopus\\build\\userPreferences',

           'D:\\proj\\Branches\\Users\\nzheng\\Main\\Canopus\\build\\logFiles',
           'D:\\proj\\Branches\\Users\\nzheng\\Main\\Canopus\\build\\userPreferences']

for path in folders:
    if os.path.exists(path):
        print('Removing ' + path + '...')
        shutil.rmtree(path)
        print('done')
    else:
        print(path + ' already doesn\'t exist')

